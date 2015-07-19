/**    
 * @Title: AuthorityService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月22日 下午10:55:51 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.security2.AuthorityMapper;
import com.beauty.entity.security2.Authority;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: AuthorityService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月22日 下午10:55:51
 * 
 */
@Service("authorityService")
public class AuthorityService extends BaseMapperService<Authority> {

	@Autowired
	private AuthorityMapper authorityMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return this.authorityMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Authority authority) {
		return this.authorityMapper.insertSelective(authority);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Authority selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.authorityMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Authority authority) {
		return this.authorityMapper.updateByPrimaryKeySelective(authority);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPageCount(java.lang.Object)
	 */
	@Override
	public int selectByPageCount(Authority authority) {
		return this.authorityMapper.selectByPageCount(authority);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPage(java.lang.Object)
	 */
	// @Cacheable(value=RedisCacheKey._AUTHORITY_PAGE_KEY,
	// key="#authority.getPage().toString()",
	// condition="#authority.getAuthorityName() eq null")
	@Override
	public List<Authority> selectByPage(Authority authority) {
		return this.authorityMapper.selectByPage(authority);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKeys(java.util.List)
	 */
	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.authorityMapper.deleteByPrimaryKeys(record);
	}

}
