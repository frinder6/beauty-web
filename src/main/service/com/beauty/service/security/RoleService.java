/**    
 * @Title: RoleService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月25日 下午5:07:07 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.security2.RoleMapper;
import com.beauty.entity.security2.Role;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: RoleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月25日 下午5:07:07
 * 
 */
@Service("roleService")
public class RoleService extends BaseMapperService<Role> {

	@Autowired
	private RoleMapper roleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return this.roleMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Role role) {
		return this.roleMapper.insertSelective(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Role selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.roleMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Role role) {
		return this.roleMapper.updateByPrimaryKeySelective(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPageCount(java.lang.Object)
	 */
	@Override
	public int selectByPageCount(Role role) {
		return this.roleMapper.selectByPageCount(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPage(java.lang.Object)
	 */
	// @Cacheable(value = RedisCacheKey._ROLE_PAGE_KEY, key =
	// "#role.getPage().toString()", condition = "#role.getRoleName() eq null")
	@Override
	public List<Role> selectByPage(Role role) {
		return this.roleMapper.selectByPage(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKeys(java.util.List)
	 */
	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.roleMapper.deleteByPrimaryKeys(record);
	}

}
