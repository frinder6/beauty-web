/**    
 * @Title: BaseDao.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月18日 下午10:48:48 
 * @version V1.0   
 */
package com.beauty.dao.base;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BaseDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月18日 下午10:48:48
 * 
 */
@Component("baseDao")
public class BaseDao<T> implements IDao<T> {

	@Autowired(required = true)
	protected SqlSession sqlSessionTemplate;

	@Autowired(required = true)
	protected HibernateTemplate hibernateTemplate;

	@Override
	public int insert(String sql, T arg1) {
		return this.sqlSessionTemplate.insert(sql, arg1);
	}

	@Override
	public int delete(String sql, String arg1) {
		return this.sqlSessionTemplate.delete(sql, arg1);
	}

	@Override
	public int update(String sql, T arg1) {
		return this.sqlSessionTemplate.update(sql, arg1);
	}

	@Override
	public List<T> query(String sql) {
		return this.sqlSessionTemplate.selectList(sql);
	}

	@Override
	public List<T> query(String sql, T arg1) {
		return this.sqlSessionTemplate.selectList(sql, arg1);
	}

	@Override
	public T queryOne(String sql) {
		return this.sqlSessionTemplate.selectOne(sql);
	}

	@Override
	public T queryOne(String sql, T arg1) {
		return this.sqlSessionTemplate.selectOne(sql, arg1);
	}

	@Override
	public int deletes(String sql, List<String> arg1) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete(sql, arg1);
	}

	@Override
	public void persist(T arg) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.persist(arg);
	}

	@Override
	public void remove(T arg) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(arg);
	}

	@Override
	public void merge(T arg) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.merge(arg);
	}

	@Override
	public T findById(Class<T> arg, Long id) {
		// TODO Auto-generated method stub
		// return this.hibernateTemplate.get(arg, id);
		return this.hibernateTemplate.load(arg, id);
	}

}
