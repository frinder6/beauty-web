/**    
 * @Title: StringUtil.java  
 * @Package com.mvc.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月29日 下午5:40:17 
 * @version V1.0   
 */
package com.beauty.util;

/**
 * @ClassName: StringUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年1月29日 下午5:40:17
 * 
 */
public class StringUtil {

	/**
	 * 
	 * @Title: valueOf
	 * @Description: TODO(重写String.valueOf方法)
	 * @author frinder_liu
	 * @param obj
	 * @return
	 * @return String
	 * @date 2015年5月30日 下午5:13:20
	 * @throws
	 */
	public static String valueOf(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 
	 * @Title: subString
	 * @Description: TODO(截取指定长度的字符串)
	 * @author frinder_liu
	 * @param source
	 * @param maxLen
	 * @return String
	 * @date 2015年2月4日 下午9:10:28 2015 下午9:10:28
	 * @throws
	 */
	public static String subString(String source, int maxLen) {
		int len = source.length();
		if (len <= maxLen) {
			return source;
		} else {
			return source.substring(0, maxLen - 1) + "...";
		}
	}

	/**
	 * 
	 * @Title: getColums
	 * @Description: TODO(获取列)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:08:22
	 * @throws
	 */
	public static String getColums(String source) {
		// 接收列
		String colums = " * ";
		// 获取列 名
		if (source.indexOf("*") == -1) {
			// 起始、终止位置索引
			int from, to;
			// 转大写
			String temp = source.toUpperCase();
			from = temp.indexOf("SELECT") + 6;
			to = temp.indexOf("FROM");
			colums = source.substring(from, to);
		}
		return colums;
	}

	/**
	 * 
	 * @Title: getTbname
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:12:14
	 * @throws
	 */
	public static String getTbname(String source) {
		String tbname;
		int from, to;
		// 转大写
		String temp = source.toUpperCase();
		// 获取表名
		from = temp.indexOf("FROM") + 4;
		if (temp.indexOf("WHERE") > -1) {
			to = temp.indexOf("WHERE");
			tbname = source.substring(from, to);
		} else {
			if (temp.indexOf("LIMIT") > -1) {
				to = temp.indexOf("LIMIT");
				tbname = source.substring(from, to);
			} else {
				tbname = source.substring(from);
			}
		}
		return tbname.trim();
	}

	/**
	 * 
	 * @Title: getWhere
	 * @Description: TODO(获取where条件)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:14:21
	 * @throws
	 */
	public static String getWhere(String source) {
		String where = "WHERE 1 = 1";
		int from;
		// 转大写
		String temp = source.toUpperCase();
		// 获取表名
		if (temp.indexOf("WHERE") > -1) {
			from = temp.indexOf("WHERE");
			where = source.substring(from);
		}
		return where;
	}

	/**
	 * 
	 * @Title: aimString
	 * @Description: TODO(获取转换SQL)
	 * @author frinder_liu
	 * @param dbname
	 * @param source
	 * @param type
	 *            1 查询记录明细，2 查询记录数
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:22:33
	 * @throws
	 */
	public static String aimString(String dbname, String source, int type) {
		StringBuffer aimStr;
		// 接收列、表名、起始、终止位置索引
		String colums = getColums(source);
		String tbname = getTbname(source);
		String where = getWhere(source);
		if (type == 1) {
			aimStr = new StringBuffer("SELECT %s FROM %s.%s %s");
			return String.format(aimStr.toString(), colums, dbname, tbname, where);
		} else {
			aimStr = new StringBuffer("SELECT count(1) total FROM %s.%s %s");
			return String.format(aimStr.toString(), dbname, tbname, where);
		}
	}

	public static void main(String[] args) {
		String sql = "a,b,c";
		String[] sqls = sql.split("\\,");
		System.out.println(sqls[2]);

	}

}
