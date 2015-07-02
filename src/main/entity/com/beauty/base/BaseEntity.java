/**    
 * @Title: BasePage.java  
 * @Package com.mvc.ibatis.entity  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月22日 下午10:22:43 
 * @version V1.0   
 */
package com.beauty.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.beauty.util.CamelCaseUtils;

/**
 * @ClassName: BasePage
 * @Description: TODO(分页基类)
 * @author frinder_liu
 * @date 2015年1月22日 下午10:22:43
 * 
 */
public abstract class BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	// 当前页
	private Integer page = 1;

	// 每页记录数
	private Integer rows = 10;

	// 起始索引
	private Integer from = 1;

	// 排序（字段：类）
	private String sort;

	// 数据库排序列
	private String sortColumn;

	// 排序方式 asc & desc
	private String order;

	/**
	 * 登陆用户名
	 */
	private String usercode;

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return the from
	 */
	public Integer getFrom() {
		from = (page - 1) * rows;
		return from;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the sortColumn
	 */
	public String getSortColumn() {
		if (null != sort && null != order) {
			List<String> sorts = Arrays.asList(sort.split("\\,"));
			List<String> orders = Arrays.asList(order.split("\\,"));
			if (sorts.size() == orders.size()) {
				String s, o;
				StringBuffer cs = new StringBuffer();
				String temp = "%s %s,";
				for (int i = 0; i < sorts.size(); i++) {
					s = CamelCaseUtils.toUnderlineName(sorts.get(i));
					o = orders.get(i);
					cs.append(String.format(temp, s, o));
				}
				sortColumn = cs.toString();
			}
		}
		return sortColumn;
	}

	/**
	 * @param sortColumn
	 *            the sortColumn to set
	 */
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the usercode
	 */
	public String getUsercode() {
		return usercode;
	}

	/**
	 * @param usercode
	 *            the usercode to set
	 */
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

}
