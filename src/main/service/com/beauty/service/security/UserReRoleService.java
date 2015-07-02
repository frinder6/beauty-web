/**    
 * @Title: UserReRoleService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月18日 下午11:16:02 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.base.BaseMapperService;
import com.beauty.dao.security2.UserReRoleMapper;
import com.beauty.entity.security2.UserReRole;

/**
 * @ClassName: UserReRoleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午11:16:02
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("userReRoleService")
public class UserReRoleService extends BaseMapperService {

	@Autowired
	private UserReRoleMapper userReRoleMapper;

	@Override
	public int insertSelective(Object record) {
		UserReRole userReRole = (UserReRole) record;
		return this.userReRoleMapper.insertSelective(userReRole);
	}

	@Override
	public Object selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.userReRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<?> selectByPage(Object record) {
		UserReRole userReRole = (UserReRole) record;
		return this.userReRoleMapper.selectByPage(userReRole);
	}

	@Override
	public int selectByPageCount(Object record) {
		UserReRole userReRole = (UserReRole) record;
		return this.userReRoleMapper.selectByPageCount(userReRole);
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		return this.userReRoleMapper.deleteByPrimaryKeys(record);
	}

}
