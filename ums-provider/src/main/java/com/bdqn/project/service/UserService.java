package com.bdqn.project.service;

import com.bdqn.project.pojo.entity.User;
import com.bdqn.project.pojo.vo.PageVO;

import java.util.List;

/**
 * <b>用户功能业务层接口</b>
 * @author hsl
 * @version 5.0.0
 */
public interface UserService {
	/**
	 * <b>分页查询信息</b>
	 * @param pageVO
	 * @param query
	 * @return
	 * @throws Exception
	 */
	PageVO<User> getByPage(PageVO<User> pageVO, User query) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(User user) throws Exception;

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean updateUser(User user) throws Exception;

	/**
	 * <b>根据用户主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteById(Long id) throws Exception;

	/**
	 * <b>根据用户主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getById(Long id) throws Exception;

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	User getByCellphone(String cellphone) throws Exception;

	/**
	 * <b>查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> getListByQuery(User query) throws Exception;
}
