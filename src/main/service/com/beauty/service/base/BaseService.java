/**    
 * @Title: BaseService.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月18日 下午10:51:20 
 * @version V1.0   
 */
package com.beauty.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.dao.base.IDao;

/**
 * @ClassName: BaseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午10:51:20
 * 
 */
@Component("baseService")
public class BaseService<T> implements IService<T> {

	@Autowired
	private IDao<T> baseDao;

	@Override
	public int insert(String sql, T arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.insert(sql, arg1);
	}

	@Override
	public int delete(String sql, String arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.delete(sql, arg1);
	}

	@Override
	public int update(String sql, T arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.update(sql, arg1);
	}

	@Override
	public List<T> query(String sql) {
		// TODO Auto-generated method stub
		return this.baseDao.query(sql);
	}

	@Override
	public List<T> query(String sql, T arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.query(sql, arg1);
	}

	@Override
	public T queryOne(String sql) {
		// TODO Auto-generated method stub
		return this.baseDao.queryOne(sql);
	}

	@Override
	public T queryOne(String sql, T arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.queryOne(sql, arg1);
	}

	@Override
	public T selectByPage(String sql, T arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.queryOne(sql, arg1);
	}

	@Override
	public int deletes(String sql, List<String> arg1) {
		// TODO Auto-generated method stub
		return this.baseDao.deletes(sql, arg1);
	}

	@Override
	public int selectByPageCount(String sql, T arg1) {
		// TODO Auto-generated method stub
		return (Integer) this.baseDao.queryOne(sql, arg1);
	}

	@Override
	public void persist(T arg) {
		// TODO Auto-generated method stub
		this.baseDao.persist(arg);
	}

	@Override
	public void remove(T arg) {
		// TODO Auto-generated method stub
		this.baseDao.remove(arg);
	}

	@Override
	public void merge(T arg) {
		// TODO Auto-generated method stub
		this.baseDao.merge(arg);
	}

	@Override
	public T findById(Class<T> arg, Long id) {
		// TODO Auto-generated method stub
		return this.baseDao.findById(arg, id);
	}

}
