package com.beauty.entity.security2;

import com.beauty.base.security.RecommonEntity;

public class UserReRole extends RecommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_user_role.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long userid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_user_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long roleid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_user_role.userId
	 *
	 * @return the value of beauty_user_role.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_user_role.userId
	 *
	 * @param userid
	 *            the value for beauty_user_role.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_user_role.roleId
	 *
	 * @return the value of beauty_user_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_user_role.roleId
	 *
	 * @param roleid
	 *            the value for beauty_user_role.roleId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
}