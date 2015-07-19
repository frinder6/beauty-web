/**    
 * @Title: IService.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月18日 下午10:46:38 
 * @version V1.0   
 */
package com.beauty.service.base;

import java.util.List;

/**
 * @ClassName: IService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午10:46:38
 * 
 */
public interface IService<T> {
	
	public void persist(T arg);

	public void remove(T arg);

	public void merge(T arg);

	public T findById(Class<T> arg, Long id);

	public int insert(String sql, T arg1);

	public int delete(String sql, String arg1);

	public int update(String sql, T arg1);

	public List<T> query(String sql);

	public List<T> query(String sql, T arg1);

	public T queryOne(String sql);

	public T queryOne(String sql, T arg1);
	
	public T selectByPage(String sql, T arg1);
	
	public int selectByPageCount(String sql, T arg1);
	
	public int deletes(String sql, List<String> arg1);

}
