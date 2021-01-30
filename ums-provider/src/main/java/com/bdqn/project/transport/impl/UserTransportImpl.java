package com.bdqn.project.transport.impl;

import com.bdqn.project.pojo.entity.User;
import com.bdqn.project.pojo.vo.PageVO;
import com.bdqn.project.pojo.vo.QueryPageVO;
import com.bdqn.project.service.UserService;
import com.bdqn.project.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>用户功能传输层接口实现类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@RestController("userTransport")
@RequestMapping("/trans/user")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>分页查询信息</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query")
	@Override
	public PageVO<User> getByPage(@RequestBody QueryPageVO<User> queryPageVO) throws Exception {
		// 提取 QueryPageVO 中的数据
		PageVO<User> pageVO = queryPageVO.getPageVO();
		User query = queryPageVO.getQuery();
		return userService.getByPage(pageVO, query);
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean updateUser(@RequestBody User user) throws Exception {
		return userService.updateUser(user);
	}

	/**
	 * <b>根据用户主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete/id")
	@Override
	public boolean deleteById(@RequestParam Long id) throws Exception {
		return userService.deleteById(id);
	}

	/**
	 * <b>根据用户主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query/id")
	@Override
	public User getById(@RequestParam Long id) throws Exception {
		return userService.getById(id);
	}

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query/Cellphone")
	@Override
	public User getByCellphone(@RequestParam String cellphone) throws Exception {
		return userService.getByCellphone(cellphone);
	}

	/**
	 * <b>查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<User> getListByQuery(User query) throws Exception {
		return userService.getListByQuery(query);
	}
}
