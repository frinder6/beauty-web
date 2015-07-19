/**    
 * @Title: ResourceService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月1日 下午4:56:12 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.security2.ResourceMapper;
import com.beauty.entity.security2.Resource;
import com.beauty.service.base.BaseMapperService;

/**
 * @ClassName: ResourceService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:56:12
 * 
 */
@Service("resourceService")
public class ResourceService extends BaseMapperService<Resource> {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		int result = this.resourceMapper.deleteByPrimaryKey(id);
		return result;
	}

	@Override
	public int insertSelective(Resource resource) {
		int result = this.resourceMapper.insertSelective(resource);
		return result;
	}

	@Override
	public Resource selectByPrimaryKey(Long id) {
		return this.resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Resource resource) {
		return this.resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public int selectByPageCount(Resource resource) {
		return this.resourceMapper.selectByPageCount(resource);
	}

	// @Cacheable(value = RedisCacheKey._RESOURCE_PAGE_KEY, key =
	// "#resource.getPage().toString()",
	// condition="#resource.getResourceName() eq null")
	@Override
	public List<Resource> selectByPage(Resource resource) {
		return this.resourceMapper.selectByPage(resource);
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return this.resourceMapper.deleteByPrimaryKeys(record);
	}

}
