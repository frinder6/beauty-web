/**    
 * @Title: RoleReAuthorityService.java  
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

import com.beauty.dao.security2.RoleReAuthorityMapper;
import com.beauty.entity.security2.RoleReAuthority;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: RoleReAuthorityService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午11:16:02
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("roleReAuthorityService")
public class RoleReAuthorityService extends BaseMapperService {

	@Autowired
	private RoleReAuthorityMapper roleReAuthorityMapper;

	@Override
	public int insertSelective(Object record) {
		return this.roleReAuthorityMapper.insertSelective(record);
	}

	@Override
	public Object selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.roleReAuthorityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<?> selectByPage(Object record) {
		RoleReAuthority roleReAuthority = (RoleReAuthority) record;
		return this.roleReAuthorityMapper.selectByPage(roleReAuthority);
	}

	@Override
	public int selectByPageCount(Object record) {
		RoleReAuthority roleReAuthority = (RoleReAuthority) record;
		return this.roleReAuthorityMapper.selectByPageCount(roleReAuthority);
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		return this.roleReAuthorityMapper.deleteByPrimaryKeys(record);
	}

}
