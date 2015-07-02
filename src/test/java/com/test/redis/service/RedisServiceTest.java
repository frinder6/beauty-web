package com.test.redis.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beauty.entity.security2.User;
import com.beauty.redis.RedisListService;
import com.beauty.redis.RedisService;

public class RedisServiceTest {

	private ApplicationContext applicationContext;

	private RedisService redisService;
	
	private RedisListService redisListService;

	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("spring-conf/applicationContext-junit.xml");
		redisService = applicationContext.getBean("redisService", RedisService.class);
		System.out.println(redisService);
		
		redisListService = applicationContext.getBean("redisListService", RedisListService.class);
	}

	// @Test
	public void testSet() {
		redisService.set("hello", "world");
		System.out.println(redisService.getValue("hello"));
		System.out.println("--------------------------");
		User user = new User();
		user.setCreater("abcde");
		user.setCreateTime(new Date());
		redisService.set("user", user);
		System.out.println(redisService.getValue("user"));
		System.out.println("----------------------");
		List<String> list = new ArrayList<String>() {
			/**
			 * @Fields serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			{
				add("124");
				add("abc");
			}
		};
		redisService.set("list", list);
		System.out.println(redisService.getValue("list"));
	}

	@Test
	public void testGetValue() {
		User user = new User();
		user.setCreater("abcde");
		user.setCreateTime(new Date());
		redisListService.set("users", user);
		User user2 = new User();
		user2.setCreater("12345");
		user2.setCreateTime(new Date());
		redisListService.set("users", user2);
		for (int i = 0; i < 2; i++) {
			System.out.println(redisListService.get("users"));
		}
	}

	// @Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	// @Test
	public void testClear() {
		fail("Not yet implemented");
	}

}
