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

import com.beauty.dao.security2.GroupMapper;
import com.beauty.entity.security2.Group;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: GroupService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月25日 下午5:07:07
 * 
 */
@Service("groupService")
public class GroupService extends BaseMapperService<Group> {

	@Autowired
	private GroupMapper groupMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return this.groupMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Group group) {
		return this.groupMapper.insertSelective(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Group selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.groupMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Group group) {
		return this.groupMapper.updateByPrimaryKeySelective(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPageCount(java.lang.Object)
	 */
	@Override
	public int selectByPageCount(Group group) {
		return this.groupMapper.selectByPageCount(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#selectByPage(java.lang.Object)
	 */
	@Override
	public List<Group> selectByPage(Group group) {
		return this.groupMapper.selectByPage(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvc.base.IService#deleteByPrimaryKeys(java.util.List)
	 */
	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.groupMapper.deleteByPrimaryKeys(record);
	}

}
