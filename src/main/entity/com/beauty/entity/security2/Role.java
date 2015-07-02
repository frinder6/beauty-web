package com.beauty.entity.security2;

import com.beauty.base.security.CommonEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Role extends CommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_role.role_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String roleName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_role.role_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String roleCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_role.role_name
	 *
	 * @return the value of beauty_role.role_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_role.role_name
	 *
	 * @param roleName
	 *            the value for beauty_role.role_name
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_role.role_code
	 *
	 * @return the value of beauty_role.role_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getRoleCode() {
		if (null != roleCode) {
			roleCode = roleCode.toUpperCase();
		}
		return roleCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_role.role_code
	 *
	 * @param roleCode
	 *            the value for beauty_role.role_code
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

}