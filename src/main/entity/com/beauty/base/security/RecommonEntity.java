/**    
 * @Title: RecommonEntity.java  
 * @Package com.mvc.model  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月20日 下午9:55:01 
 * @version V1.0   
 */
package com.beauty.base.security;

import java.util.ArrayList;
import java.util.List;

import com.beauty.base.BaseEntity;

/**
 * @ClassName: RecommonEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月20日 下午9:55:01
 * 
 */
public class RecommonEntity extends BaseEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private List<String> inserts = new ArrayList<String>();

	private List<String> deletes = new ArrayList<String>();

	private boolean isSelected;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the inserts
	 */
	public List<String> getInserts() {
		return inserts;
	}

	/**
	 * @param inserts
	 *            the inserts to set
	 */
	public void setInserts(List<String> inserts) {
		this.inserts = inserts;
	}

	/**
	 * @return the deletes
	 */
	public List<String> getDeletes() {
		return deletes;
	}

	/**
	 * @param deletes
	 *            the deletes to set
	 */
	public void setDeletes(List<String> deletes) {
		this.deletes = deletes;
	}

	/**
	 * @return the isSelected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected
	 *            the isSelected to set
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
