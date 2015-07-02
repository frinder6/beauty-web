package com.beauty.entity.security2;

import com.beauty.base.security.RecommonEntity;

public class GroupReRole extends RecommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_group_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long roleid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_group_role.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long groupid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_group_role.roleId
	 *
	 * @return the value of beauty_group_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_group_role.roleId
	 *
	 * @param roleid
	 *            the value for beauty_group_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_group_role.groupId
	 *
	 * @return the value of beauty_group_role.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getGroupid() {
		return groupid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_group_role.groupId
	 *
	 * @param groupid
	 *            the value for beauty_group_role.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
}