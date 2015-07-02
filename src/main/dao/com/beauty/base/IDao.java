/**    
 * @Title: IDao.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月18日 下午10:48:15 
 * @version V1.0   
 */
package com.beauty.base;

import java.util.List;

/**
 * @ClassName: IDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午10:48:15
 * 
 */
public interface IDao<T> {

	public int insert(String sql, T arg1);

	public int delete(String sql, String arg1);
	
	public int deletes(String sql, List<String> arg1);

	public int update(String sql, T arg1);

	public List<T> query(String sql);

	public List<T> query(String sql, T arg1);

	public T queryOne(String sql);

	public T queryOne(String sql, T arg1);
	
}
