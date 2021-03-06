package com.beauty.entity.security2;

import com.beauty.base.security.RecommonEntity;

public class UserReGroup extends RecommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_user_group.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long userid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_user_group.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Long groupid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_user_group.userId
	 *
	 * @return the value of beauty_user_group.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_user_group.userId
	 *
	 * @param userid
	 *            the value for beauty_user_group.userId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_user_group.groupId
	 *
	 * @return the value of beauty_user_group.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Long getGroupid() {
		return groupid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_user_group.groupId
	 *
	 * @param groupid
	 *            the value for beauty_user_group.groupId
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
}