/**    
 * @Title: BeautyAuthorityResourceDao.java  
 * @Package com.beauty.dao.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年7月19日 下午8:36:16 
 * @version V1.0   
 */
package com.beauty.dao.security;

import org.springframework.stereotype.Component;

import com.beauty.dao.base.BaseDao;
import com.beauty.entity.security.BeautyAuthorityResource;

/**
 * @ClassName: BeautyAuthorityResourceDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年7月19日 下午8:36:16
 * 
 */


@Component("beautyAuthorityResourceDao")
public class BeautyAuthorityResourceDao extends BaseDao<BeautyAuthorityResource> {

	@Override
	public void persist(BeautyAuthorityResource arg) {
		// TODO Auto-generated method stub
		super.persist(arg);
	}

	@Override
	public void remove(BeautyAuthorityResource arg) {
		// TODO Auto-generated method stub
		super.remove(arg);
	}

	@Override
	public void merge(BeautyAuthorityResource arg) {
		// TODO Auto-generated method stub
		super.merge(arg);
	}

	@Override
	public BeautyAuthorityResource findById(Class<BeautyAuthorityResource> arg, Long id) {
		// TODO Auto-generated method stub
		return super.findById(arg, id);
	}

}
