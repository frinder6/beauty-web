/**    
 * @Title: RedisValueService.java  
 * @Package com.beauty.redis  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月6日 下午11:14:15 
 * @version V1.0   
 */
package com.beauty.redis;

import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisValueService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年6月6日 下午11:14:15
 * 
 */
@Component("redisValueService")
public class RedisValueService extends BaseRedisService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beauty.redis.BaseRedisService#set(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void set(String key, Object value) {
		this.redisTemplate.opsForValue().set(key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beauty.redis.BaseRedisService#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return this.redisTemplate.opsForValue().get(key);
	}

}
