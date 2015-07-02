/**    
 * @Title: RedisListService.java  
 * @Package com.test.redis.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月6日 下午11:01:56 
 * @version V1.0   
 */
package com.beauty.redis;

import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisListService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年6月6日 下午11:01:56
 * 
 */
@Component("redisListService")
public class RedisListService extends BaseRedisService {

	@Override
	public void set(String key, Object value) {
		// TODO Auto-generated method stub
		this.redisTemplate.opsForList().leftPush(key, value);
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return this.redisTemplate.opsForList().rightPop(key);
	}

	/**
	 * 压栈
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long push(String key, String value) {
		return this.redisTemplate.opsForList().leftPush(key, value);
	}

	/**
	 * 出栈
	 * 
	 * @param key
	 * @return
	 */
	public Object pop(String key) {
		return this.redisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 入队
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long in(String key, String value) {
		return this.redisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 出队
	 * 
	 * @param key
	 * @return
	 */
	public Object out(String key) {
		return this.redisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 栈/队列长
	 * 
	 * @param key
	 * @return
	 */
	public Long length(String key) {
		return this.redisTemplate.opsForList().size(key);
	}

	/**
	 * 范围检索
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Object range(String key, int start, int end) {
		return this.redisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 移除
	 * 
	 * @param key
	 * @param i
	 * @param value
	 */
	public void remove(String key, long i, String value) {
		this.redisTemplate.opsForList().remove(key, i, value);
	}

	/**
	 * 置值
	 * 
	 * @param key
	 * @param index
	 * @param value
	 */
	public void set(String key, long index, String value) {
		this.redisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * 裁剪
	 * 
	 * @param key
	 * @param start
	 * @param end
	 */
	public void trim(String key, long start, int end) {
		this.redisTemplate.opsForList().trim(key, start, end);
	}

}
