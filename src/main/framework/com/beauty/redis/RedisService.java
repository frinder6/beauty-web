/**    
 * @Title: RedisService.java  
 * @Package com.mvc.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月31日 上午12:09:05 
 * @version V1.0   
 */
package com.beauty.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年1月31日 上午12:09:05
 * 
 */
@Component("redisService")
public class RedisService {

	@Resource(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate;

	/**
	 * 
	 * @Title: set
	 * @Description: TODO(设置值:String)
	 * @author frinder_liu
	 * @param key
	 * @param value
	 * @return void
	 * @date 2015年5月28日 下午9:35:47
	 * @throws
	 */
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description: TODO(获取值:String)
	 * @author frinder_liu
	 * @param key
	 * @return
	 * @return Object
	 * @date 2015年5月28日 下午9:35:58
	 * @throws
	 */
	public Object getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除值:String)
	 * @author frinder_liu
	 * @param key
	 * @return void
	 * @date 2015年5月28日 下午9:36:08
	 * @throws
	 */
	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: TODO(清空数据)
	 * @author frinder_liu
	 * @return void
	 * @date 2015年6月4日 下午10:57:07
	 * @throws
	 */
	public void clear() {
		redisTemplate.getConnectionFactory().getConnection().flushDb();
	}

}
