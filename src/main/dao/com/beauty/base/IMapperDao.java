/**    
 * @Title: IDAO.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月4日 下午1:03:23 
 * @version V1.0   
 */
package com.beauty.base;

import java.util.List;

/**
 * 
 * @ClassName: IMapperDao
 * @Description: TODO(mybatis自动生成接口dao类)
 * @author frinder_liu
 * @date 2015年5月30日 下午4:41:50
 * 
 * @param <T>
 */
public interface IMapperDao<T> {

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
