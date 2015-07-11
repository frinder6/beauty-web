package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

public class JavaHttp {

	private Logger logger = Logger.getLogger(getClass());

	private final HttpClient client = HttpClients.createDefault();

	// 保存properties属性
	private Map<String, String> props = new HashMap<String, String>();

	// 添加处理器
	private IResponseAdapter adapter;

	public JavaHttp(IResponseAdapter adapter) {
		super();
		this.adapter = adapter;
	}

	// 登陆标识
	private boolean isLog = false;

	/**
	 * 
	 * @Title: init
	 * @Description: TODO(init)
	 * @author frinder_liu
	 * @throws IOException
	 * @return void
	 * @date 2015年7月10日 下午5:02:45
	 * @throws
	 */
	private void init() throws IOException {
		Properties properties = new Properties();
		properties.load(ClassLoader.getSystemResourceAsStream("com/config.properties"));
		Set<Entry<Object, Object>> sets = properties.entrySet();
		for (Entry<Object, Object> entry : sets) {
			props.put(entry.getKey().toString(), entry.getValue().toString());
		}
		logger.info("props : " + JSON.toJSONString(props));
	}

	/**
	 * 
	 * @Title: login
	 * @Description: TODO(登陆方法)
	 * @author frinder_liu
	 * @throws Exception
	 * @return void
	 * @date 2015年7月10日 下午5:01:34
	 * @throws
	 */
	public void login() throws Exception {
		if (!isLog) {
			init(); // 初始化
			post(props.get("sys.login"), props);
			// 标识已登陆
			isLog = true;
		}
	}

	public void query() throws Exception {
		if (!isLog) {
			login();
		}
		post(props.get("sys.query"), props);
	}

	/**
	 * 
	 * @Title: post
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param url
	 * @param params
	 * @throws Exception
	 * @return void
	 * @date 2015年7月10日 下午5:06:04
	 * @throws
	 */
	public void post(String url, Map<String, String> params) throws Exception {
		logger.info("post start : <<---------------------------------------------------------->>");
		// post 请求
		HttpPost post = new HttpPost(url);
		// 登陆参数
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> map : params.entrySet()) {
			formParams.add(new BasicNameValuePair(map.getKey(), map.getValue()));
		}
		if (!formParams.isEmpty()) {
			// 设置请求参数
			post.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
		}
		logger.info("post request headers : " + JSON.toJSONString(post.getAllHeaders()));
		// 执行请求
		HttpResponse response = client.execute(post);
		// 返回响应结果
		printResponse(response);
		logger.info("post end : <<---------------------------------------------------------->>");
	}

	/**
	 * 
	 * @Title: get
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param url
	 * @throws Exception
	 * @return void
	 * @date 2015年7月10日 下午5:06:08
	 * @throws
	 */
	public void get(String url) throws Exception {
		logger.info("get start : <<---------------------------------------------------------->>");
		HttpGet get = new HttpGet(url);
		logger.info("get request headers : " + JSON.toJSONString(get.getAllHeaders()));
		// 执行请求
		HttpResponse response = client.execute(get);
		// 返回响应结果
		printResponse(response);
		logger.info("get end : <<---------------------------------------------------------->>");

	}

	public void printResponse(HttpResponse httpResponse) throws Exception {
		logger.info("print start : <<---------------------------------------------------------->>");
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		// 响应状态
		logger.info("httpResponse.headers : " + JSON.toJSONString(httpResponse.headerIterator()));
		// 判断响应实体是否为空
		if (entity != null) {
			String responseString = EntityUtils.toString(entity);
			logger.info("response length:" + responseString.length());
			// logger.info("response content:" + responseString);
			// 调用处理方法
			adapter.handle(responseString);
		}
		logger.info("print end : <<---------------------------------------------------------->>");
	}

	public boolean isLog() {
		return isLog;
	}

	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}

	public IResponseAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(IResponseAdapter adapter) {
		this.adapter = adapter;
	}

}
