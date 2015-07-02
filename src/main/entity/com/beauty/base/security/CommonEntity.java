/**    
 * @Title: CommonEntity.java  
 * @Package com.mvc.base  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月20日 下午9:48:59 
 * @version V1.0   
 */
package com.beauty.base.security;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.beauty.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @ClassName: CommonEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月20日 下午9:48:59
 * 
 */
public abstract class CommonEntity extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String remark;

	private Byte enable;

	private Byte isSys;

	private String creater;

	private Date createTime;

	private String modifer;

	private Date lastModifyTime;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Byte getEnable() {
		return enable;
	}

	public void setEnable(Byte enable) {
		this.enable = enable;
	}

	public Byte getIsSys() {
		return isSys;
	}

	public void setIsSys(Byte isSys) {
		this.isSys = isSys;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifer() {
		return modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer == null ? null : modifer.trim();
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
