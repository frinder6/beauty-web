/**    
 * @Title: GroupService.java  
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

import com.beauty.base.BaseMapperService;
import com.beauty.dao.security2.ArgroupMapper;
import com.beauty.entity.security2.Argroup;

/**
 * @ClassName: GroupService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月25日 下午5:07:07
 * 
 */
@Service("argroupService")
public class ArgroupService extends BaseMapperService<Argroup> {

	@Autowired
	private ArgroupMapper argroupMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return this.argroupMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Argroup group) {
		return this.argroupMapper.insertSelective(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Argroup selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.argroupMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Argroup group) {
		return this.argroupMapper.updateByPrimaryKeySelective(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPageCount(java.lang.Object)
	 */
	@Override
	public int selectByPageCount(Argroup group) {
		return this.argroupMapper.selectByPageCount(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPage(java.lang.Object)
	 */
	// @Cacheable(value = RedisCacheKey._ARGROUP_PAGE_KEY, key =
	// "#group.getPage().toString()", condition =
	// "#group.getGroupName() eq null")
	@Override
	public List<Argroup> selectByPage(Argroup group) {
		return this.argroupMapper.selectByPage(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKeys(java.util.List)
	 */
	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.argroupMapper.deleteByPrimaryKeys(record);
	}

}
