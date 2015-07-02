/**    
 * @Title: IService.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月4日 下午1:03:11 
 * @version V1.0   
 */
package com.beauty.base;

import java.util.List;

/**
 * @ClassName: IService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月4日 下午1:03:11
 * 
 */
public interface IMapperService<T> extends IService<T> {

	int deleteByPrimaryKey(Long id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	int selectByPageCount(T record);

	List<T> selectByPage(T record);

	int deleteByPrimaryKeys(Object record);

}
