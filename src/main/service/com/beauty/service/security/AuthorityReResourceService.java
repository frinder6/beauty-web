/**    
 * @Title: AuthorityReResourceService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月26日 下午5:43:23 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.security2.AuthorityReResourceMapper;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: AuthorityReResourceService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月26日 下午5:43:23
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("authorityReResourceService")
public class AuthorityReResourceService extends BaseMapperService {

	@Autowired
	private AuthorityReResourceMapper authorityReResourceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Object record) {
		return this.authorityReResourceMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Object selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.authorityReResourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<?> selectByPage(Object record) {
		return (List<?>) this.authorityReResourceMapper.selectByPage(record);
	}

	@Override
	public int selectByPageCount(Object record) {
		return (Integer) this.authorityReResourceMapper.selectByPageCount(record);
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.authorityReResourceMapper.deleteByPrimaryKeys(record);
	}

}
