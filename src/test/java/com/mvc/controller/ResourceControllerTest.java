/**    
 * @Title: ResourceControllerTest.java  
 * @Package com.mvc.controller  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月1日 下午4:43:03 
 * @version V1.0   
 */
package com.mvc.controller;

/**
 * import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 * import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 */
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.security2.Resource;

/**
 * @ClassName: ResourceControllerTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:43:03
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/conf/applicationContext-junit.xml" })
public class ResourceControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	static {
		try {
			Log4jConfigurer.initLogging("file:WebContent/WEB-INF/conf/log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test method for
	 * {@link com.mvc.controller.ResourceController#selectByPrimaryKey(java.lang.Long)}
	 * .
	 */
	// @Test
	public void testSelectByPrimaryKey() {

		try {
			String url = "/resource/query/id";
			mockMvc.perform(post(url).param("id", "1")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void testInsert() {
		String url = "/resource/insert";
		Resource resource = new Resource();
		String json = JSON.toJSONString(resource);
		System.out.println(json);
		try {
			// mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
			// mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(json.getBytes())).andExpect(status().isOk());
			// mockMvc.perform(post(url).contentType(MediaType.parseMediaType("application/json;charset=UTF-8")).content(json).accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().is4xxClientError());
			System.out.println(mock(this.mockMvc, url, json));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectCascadeByParams() {
		try {
			String url = "/resource/load/menu";
			String str = mockMvc.perform(post(url)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();;
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String mock(MockMvc mvc, String uri, String json) throws UnsupportedEncodingException, Exception {
		return mvc.perform(post(uri, "json").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON).content(json.getBytes())).andReturn().getResponse().getContentAsString();
	}
}
