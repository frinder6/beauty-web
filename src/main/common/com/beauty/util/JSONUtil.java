/**    
 * @Title: JSONUtil.java  
 * @Package com.mvc.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月22日 上午12:18:43 
 * @version V1.0   
 */
package com.beauty.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: JSONUtil
 * @Description: TODO(JSON助手类)
 * @author frinder_liu
 * @date 2015年1月22日 上午12:18:43
 * 
 */
public class JSONUtil {

	/**
	 * 
	 */
	public JSONUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String toJSON(Object value) {
		return JSON.toJSONString(value);
	}

	/**
	 * 
	 * @Title: jsonToMap
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param json
	 * @return
	 * @return Map<String,String>
	 * @date 2015年4月6日 下午4:28:08
	 * @throws
	 */
	public static Map<String, Object> jsonToMap(String json) {
		Map<String, Object> retValue = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = JSON.toJavaObject(JSON.parseArray(json), List.class);
		String name, value;
		for (Map<String, Object> map : list) {
			name = String.valueOf(map.get("name"));
			value = String.valueOf(map.get("value"));
			retValue.put(name, value);
		}
		return retValue;
	}

	/**
	 * 
	 * @Title: jsonToJava
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param json
	 * @return
	 * @return Object
	 * @date 2015年5月7日 下午11:11:34
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static Object jsonToJava(String json, Class clazz) {
		return JSON.toJavaObject(JSON.parseObject(json), clazz);
	}
	
}
