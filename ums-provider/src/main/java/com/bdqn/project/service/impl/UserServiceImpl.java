package com.bdqn.project.service.impl;

import com.bdqn.project.dao.UserDao;
import com.bdqn.project.pojo.entity.User;
import com.bdqn.project.pojo.vo.PageVO;
import com.bdqn.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户功能业务层接口实现类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>分页查询信息</b>
	 * @param pageVO
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<User> getByPage(PageVO<User> pageVO, User query) throws Exception {
		// 开启 PageHelper 分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 查询列表
		List<User> userList = userDao.findListByQuery(query);
		// 通过查询获得的列表创建 PageInfo 对象
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		// 提取 PageInfo 中的数据，设定到 PageVO 中
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean saveUser(User user) throws Exception {
		// 保存用户信息
		int count = userDao.save(user);
		// 当保存成功之后，MyBatis 会将此时的用户主键存储到保存的对象中
		if (count > 0 && user.getId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateUser(User user) throws Exception {
		int count = userDao.update(user);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据用户主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean deleteById(Long id) throws Exception {
		if (userDao.deleteById(id) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据用户主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getById(Long id) throws Exception {
		// 封装查询对象
		User query = new User();
		query.setId(id);
		// 进行列表查询
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getByCellphone(String cellphone) throws Exception {
		// 封装查询对象
		User query = new User();
		query.setCellphone(cellphone);
		// 进行列表查询
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * <b>查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<User> getListByQuery(User query) throws Exception {
		return userDao.findListByQuery(query);
	}
}
