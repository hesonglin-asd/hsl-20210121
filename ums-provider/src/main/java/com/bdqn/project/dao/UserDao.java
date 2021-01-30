package com.bdqn.project.dao;

import com.bdqn.project.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>用户功能数据持久层接口</b>
 * @author hsl
 * @version 5.0.0-final
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findListByQuery(User query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(User entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(User entity) throws Exception;

	/**
	 * <b>按照主键删除对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteById(Long id) throws Exception;
}
