package com.beauty.entity.security2;

import com.beauty.base.security.CommonEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GridConfig extends CommonEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.title
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String title;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.field
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String field;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.width
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private Integer width;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.def1
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String def1;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.def2
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String def2;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column beauty_grid_config.def3
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	private String def3;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.title
	 *
	 * @return the value of beauty_grid_config.title
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.title
	 *
	 * @param title
	 *            the value for beauty_grid_config.title
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.field
	 *
	 * @return the value of beauty_grid_config.field
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getField() {
		return field;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.field
	 *
	 * @param field
	 *            the value for beauty_grid_config.field
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.width
	 *
	 * @return the value of beauty_grid_config.width
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.width
	 *
	 * @param width
	 *            the value for beauty_grid_config.width
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.def1
	 *
	 * @return the value of beauty_grid_config.def1
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getDef1() {
		return def1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.def1
	 *
	 * @param def1
	 *            the value for beauty_grid_config.def1
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setDef1(String def1) {
		this.def1 = def1 == null ? null : def1.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.def2
	 *
	 * @return the value of beauty_grid_config.def2
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getDef2() {
		return def2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.def2
	 *
	 * @param def2
	 *            the value for beauty_grid_config.def2
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setDef2(String def2) {
		this.def2 = def2 == null ? null : def2.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column beauty_grid_config.def3
	 *
	 * @return the value of beauty_grid_config.def3
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public String getDef3() {
		return def3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column beauty_grid_config.def3
	 *
	 * @param def3
	 *            the value for beauty_grid_config.def3
	 *
	 * @mbggenerated Sun May 31 21:29:11 CST 2015
	 */
	public void setDef3(String def3) {
		this.def3 = def3 == null ? null : def3.trim();
	}

}