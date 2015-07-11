package com;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResponseAdapter implements IResponseAdapter {

	// csv头
	private String[] headers = null;

	public void handle(String html) throws Exception {
		Document document = Jsoup.parse(html);
		Elements elements = document.getElementsByClass("list");
		if (!elements.isEmpty()) {
			Element element = elements.first();
			Elements trs = element.getElementsByTag("tr");
			// td行s
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			// 每一行
			Map<String, String> map;
			for (Element tr : trs) {
				// 没写过头
				if (null == headers) {
					Elements ths = tr.getElementsByTag("th");
					if (!ths.isEmpty()) {
						// 头
						headers = new String[ths.size()];
						int i = 0;
						for (Element th : ths) {
							headers[i] = th.child(0).text();
							i++;
						}
						// 写头
						CSVUtil.writeCsv(getFilename(), headers, null, false);
					}
				}
				Elements tds = tr.getElementsByTag("td");
				if (!tds.isEmpty()) {
					map = new HashMap<String, String>();
					for (int i = 0; i < headers.length; i++) {
						map.put(headers[i], tds.get(i).text());
						list.add(map);
					}
				}
			}
			if (list.size() > 0) {
				// 写内容
				CSVUtil.writeCsv(getFilename(), headers, list, true);
			}
		}
	}

	/**
	 * 
	 * @Title: getFilename
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @return
	 * @return String
	 * @date 2015年7月11日 下午3:53:45
	 * @throws
	 */
	private String getFilename() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date()).concat(".csv");
	}
}
