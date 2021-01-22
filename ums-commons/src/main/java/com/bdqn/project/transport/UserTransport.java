package com.bdqn.project.transport;

import com.bdqn.project.pojo.entity.User;
import com.bdqn.project.pojo.vo.PageVO;
import com.bdqn.project.pojo.vo.QueryPageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>用户功能传输层接口</b>
 * @author hsl
 * @version 5.0.0-final
 */
@FeignClient(name = "ums-provider")
@RequestMapping("/trans/user")
public interface UserTransport {

	/**
	 * <b>分页查询信息</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query")
	PageVO<User> getByPage(@RequestBody QueryPageVO<User> queryPageVO) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean saveUser(@RequestBody User user) throws Exception;

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean updateUser(@RequestBody User user) throws Exception;

	/**
	 * <b>根据用户主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete/id")
	boolean deleteById(@RequestParam Long id) throws Exception;

	/**
	 * <b>根据用户主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query/id")
	User getById(@RequestParam Long id) throws Exception;

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/query/Cellphone")
	User getByCellphone(@RequestParam String cellphone) throws Exception;

	/**
	 * <b>查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<User> getListByQuery(User query) throws Exception;
}
