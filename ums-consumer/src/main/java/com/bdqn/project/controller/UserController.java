package com.bdqn.project.controller;

import com.bdqn.project.controller.base.BaseController;
import com.bdqn.project.pojo.entity.User;
import com.bdqn.project.pojo.vo.PageVO;
import com.bdqn.project.pojo.vo.QueryPageVO;
import com.bdqn.project.pojo.vo.ResponseVO;
import com.bdqn.project.transport.UserTransport;
import com.bdqn.project.util.ConstantUtil;
import com.bdqn.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>用户功能控制层类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>校验手机号码是否可用</b>
	 * @param cellphone
	 * @param id 当进行注册校验时，id 为 -1，否则 id 为该用户的 id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/validation/{cellphone}/{id}")
	public ResponseVO validateCellphone(@PathVariable("cellphone") String cellphone, @PathVariable("id") Long id)
			throws Exception {
		// 判断该手机号码是否可用
		if (cellphone != null && !"".equals(cellphone.trim()) && cellphone.matches(ConstantUtil.REGEX_CELLPHONE)) {
			// 此时手机号码可用
			// 根据该手机号码查询用户信息
			User user = userTransport.getByCellphone(cellphone);
			if (user == null) {
				return ResponseVO.getSuccessResponseVO();
			} else {
				if (id != -1 && user.getId() == id) {
					// 此时用户正在进行修改操作，而且没有修改手机号码
					return ResponseVO.getSuccessResponseVO();
				}
			}

			return ResponseVO.getErrorResponseVO("该手机号码已被占用");
		} else {
			return ResponseVO.getErrorResponseVO("请填写正确的手机号码");
		}
	}

	/**
	 * <b>注册新用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/register")
	public ResponseVO registerUser(@RequestBody User user) throws Exception {
		// 校验用户所填写的信息
		// 校验手机号码是否填写
		if (user.getCellphone() == null || "".equals(user.getCellphone().trim())
				|| !user.getCellphone().matches(ConstantUtil.REGEX_CELLPHONE)) {
			// 此时用户为填写手机号码，或者手机号码为空字符串
			return ResponseVO.getErrorResponseVO("请填写手机正确的号码");
		}
		// 校验该手机号码是否可用
		User registerUser = userTransport.getByCellphone(user.getCellphone());
		if (registerUser != null) {
			// 此时通过手机号码查询到用户信息，则说明该手机号码已被占用
			return ResponseVO.getErrorResponseVO("该手机号码已被占用");
		}
		// 校验用户密码是否填写
		if (user.getPassword() == null || user.getPassword().trim().length() < 6) {
			// 密码错误
			return ResponseVO.getErrorResponseVO("请填写正确的登录密码");
		}
		// 对该密码进行加密
		user.setPassword(MD5Util.encrypt(user.getPassword().trim()));
		// 保存用户信息
		if (userTransport.saveUser(user)) {
			return ResponseVO.getSuccessResponseVO();
		}
		return ResponseVO.getErrorResponseVO("注册失败");
	}

	/**
	 * <b>用户登录</b>
	 * @param loginUser
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginUser(@RequestBody User loginUser) throws Exception {
		// 校验用户所填写的登录信息
		if (loginUser.getCellphone() != null && loginUser.getPassword() != null) {
			// 对登录密码进行加密
			loginUser.setPassword(MD5Util.encrypt(loginUser.getPassword()));
			// 查询用户信息
			List<User> userList = userTransport.getListByQuery(loginUser);
			if (userList != null && userList.size() == 1) {
				User user = userList.get(0);
				return ResponseVO.getSuccessResponseVO(user);
			}
		}

		return ResponseVO.getErrorResponseVO("登录失败");
	}

	/**
	 * <b>分页查询列表</b>
	 * @param pageNum
	 * @param pageSize
	 * @param draw
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}/{draw}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @PathVariable("draw") Integer draw, @RequestBody User query) throws Exception {
		return ResponseVO.getSuccessResponseVO(userTransport.getByPage(new QueryPageVO<User>(new PageVO<User>(pageNum, pageSize, draw), query)));
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public ResponseVO updateUser(@RequestBody User user) throws Exception {
		if (user.getCellphone() != null) {
			// 此时用户对手机号码进行修改
			// 进行手机号码唯一性校验
			if (user.getCellphone().matches(ConstantUtil.REGEX_CELLPHONE)) {
				User updateUser = userTransport.getByCellphone(user.getCellphone());
				if (updateUser == null || user.getId() == updateUser.getId()) {
					// 该手机号码可用
					return ResponseVO.getSuccessResponseVO(userTransport.updateUser(user));
				} else {
					return ResponseVO.getErrorResponseVO("该手机号码已被占用");
				}
			} else {
				return ResponseVO.getErrorResponseVO("请填写正确的手机号码");
			}
		} else {
			// 此时用户未修改手机号码
			return ResponseVO.getSuccessResponseVO(userTransport.updateUser(user));
		}
	}

	/**
	 * <b>根据主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/delete/{id}")
	public ResponseVO deleteById(@PathVariable("id") Long id) throws Exception {
		return ResponseVO.getSuccessResponseVO(userTransport.deleteById(id));
	}

	/**
	 * <b>根据主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		return ResponseVO.getSuccessResponseVO(userTransport.getById(id));
	}
}
