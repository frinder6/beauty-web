/**    
 * @Title: BaseRedisService.java  
 * @Package com.beauty.redis  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月6日 下午11:06:35 
 * @version V1.0   
 */
package com.beauty.redis;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BaseRedisService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年6月6日 下午11:06:35
 * 
 */
@Component
public abstract class BaseRedisService {

	@Resource(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate;

	/**
	 * 
	 * @Title: set
	 * @Description: TODO(存数)
	 * @author frinder_liu
	 * @param key
	 * @param value
	 * @return void
	 * @date 2015年6月6日 下午11:12:53
	 * @throws
	 */
	public abstract void set(String key, Object value);

	/**
	 * 
	 * @Title: get
	 * @Description: TODO(取数)
	 * @author frinder_liu
	 * @param key
	 * @return
	 * @return Object
	 * @date 2015年6月6日 下午11:13:04
	 * @throws
	 */
	public abstract Object get(String key);

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(单个/批量删除)
	 * @author frinder_liu
	 * @param keys
	 * @return void
	 * @date 2015年6月6日 下午11:09:53
	 * @throws
	 */
	public void delete(String... keys) {
		for (String key : keys) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(批量删除)
	 * @author frinder_liu
	 * @param keys
	 * @return void
	 * @date 2015年6月6日 下午11:08:52
	 * @throws
	 */
	public void delete(Collection<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: TODO(清空数据)
	 * @author frinder_liu
	 * @return void
	 * @date 2015年6月6日 下午11:11:38
	 * @throws
	 */
	public void clear() {
		redisTemplate.getConnectionFactory().getConnection().flushDb();
	}
}
