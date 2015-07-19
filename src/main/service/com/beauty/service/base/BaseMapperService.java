/**    
 * @Title: BaseService.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月4日 下午1:08:57 
 * @version V1.0   
 */
package com.beauty.service.base;

import java.util.List;

/**
 * @ClassName: BaseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月4日 下午1:08:57
 * 
 */
public class BaseMapperService<T> extends BaseService<T> implements IMapperService<T> {

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(T record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectByPageCount(T record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> selectByPage(T record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKeys(Object record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
