package com.beauty.entity.security2;

import java.util.List;

import com.beauty.base.security.CommonEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Resource extends CommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 子节点集合
	 */
	private List<Resource> children;

	/**
	 * 
	 */
	private String parentName;

	/**
	 * @return the children
	 */
	public List<Resource> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName
	 *            the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.resource_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String resourceName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.resource_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String resourceCode;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.resource_value
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String resourceValue;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.type
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Integer type;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.parent_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long parentId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.group_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long groupId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.group_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String groupName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_resource.level
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Integer level;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.resource_name
	 *
	 * @return the value of beauty_resource.resource_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.resource_name
	 *
	 * @param resourceName
	 *            the value for beauty_resource.resource_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName == null ? null : resourceName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.resource_code
	 *
	 * @return the value of beauty_resource.resource_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getResourceCode() {
		if (null != resourceCode) {
			resourceCode = resourceCode.toUpperCase();
		}
		return resourceCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.resource_code
	 *
	 * @param resourceCode
	 *            the value for beauty_resource.resource_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode == null ? null : resourceCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.resource_value
	 *
	 * @return the value of beauty_resource.resource_value
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getResourceValue() {
		return resourceValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.resource_value
	 *
	 * @param resourceValue
	 *            the value for beauty_resource.resource_value
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue == null ? null : resourceValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.type
	 *
	 * @return the value of beauty_resource.type
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.type
	 *
	 * @param type
	 *            the value for beauty_resource.type
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.parent_id
	 *
	 * @return the value of beauty_resource.parent_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.parent_id
	 *
	 * @param parentId
	 *            the value for beauty_resource.parent_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.group_id
	 *
	 * @return the value of beauty_resource.group_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.group_id
	 *
	 * @param groupId
	 *            the value for beauty_resource.group_id
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.group_name
	 *
	 * @return the value of beauty_resource.group_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.group_name
	 *
	 * @param groupName
	 *            the value for beauty_resource.group_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_resource.level
	 *
	 * @return the value of beauty_resource.level
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_resource.level
	 *
	 * @param level
	 *            the value for beauty_resource.level
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

}