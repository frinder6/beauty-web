/**    
 * @Title: UserService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月17日 下午8:20:16 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.security2.UserMapper;
import com.beauty.entity.security2.User;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月17日 下午8:20:16
 * 
 */
@Service("userService")
public class UserService extends BaseMapperService<User> {

	@Autowired
	private UserMapper userMapper;

	// @Cacheable(value = RedisCacheKey._USER_PAGE_KEY, key =
	// "#user.getPage().toString()", condition = "#user.getUsername() eq null")
	@Override
	public List<User> selectByPage(User user) {
		return this.userMapper.selectByPage(user);
	}

	@Override
	public int selectByPageCount(User user) {
		return this.userMapper.selectByPageCount(user);
	}

	@Override
	public int insertSelective(User user) {
		return this.userMapper.insertSelective(user);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		return this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		return this.userMapper.deleteByPrimaryKeys(record);
	}
}
