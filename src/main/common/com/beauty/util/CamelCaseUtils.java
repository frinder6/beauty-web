/**    
 * @Title: CamelCaseUtils.java  
 * @Package com.mvc.model  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月9日 下午9:20:50 
 * @version V1.0   
 */
package com.beauty.util;

/**
 * @ClassName: CamelCaseUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月9日 下午9:20:50
 * 
 */
public class CamelCaseUtils {

	private static final char SEPARATOR = '_';

	/**
	 * 
	 * @Title: toUnderlineName
	 * @Description: TODO(将驼峰格式转化为下划线格式)
	 * @author frinder_liu
	 * @param s
	 * @return
	 * @return String
	 * @date 2015年5月9日 下午9:22:40
	 * @throws
	 */
	public static String toUnderlineName(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i >= 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					if (i > 0)
						sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 
	 * @Title: toCamelCase
	 * @Description: TODO(将下划线转化为驼峰格式)
	 * @author frinder_liu
	 * @param s
	 * @return
	 * @return String
	 * @date 2015年5月9日 下午9:23:35
	 * @throws
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * @Title: toCapitalizeCamelCase
	 * @Description: TODO(首字母大写驼峰格式)
	 * @author frinder_liu
	 * @param s
	 * @return
	 * @return String
	 * @date 2015年5月9日 下午9:24:58
	 * @throws
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static void main(String[] args) {
		System.out.println(CamelCaseUtils.toUnderlineName("ISOCertifiedStaff"));
		System.out.println(CamelCaseUtils.toUnderlineName("CertifiedStaff"));
		System.out.println(CamelCaseUtils.toUnderlineName("UserID"));
		System.out.println(CamelCaseUtils.toCamelCase("iso_certified_staff"));
		System.out.println(CamelCaseUtils.toCamelCase("certified_staff"));
		System.out.println(CamelCaseUtils.toCamelCase("user_id"));
		System.out.println(CamelCaseUtils.toCapitalizeCamelCase("user_id"));
	}
}
