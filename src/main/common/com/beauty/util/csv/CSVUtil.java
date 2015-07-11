package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

public class CSVUtil {

	/**
	 * 
	 * @Title: writeCsv
	 * @Description: TODO(写方法)
	 * @author frinder_liu
	 * @param filename
	 * @param headers
	 * @param list
	 * @throws Exception
	 * @return void
	 * @date 2015年7月11日 下午2:43:01
	 * @throws
	 */
	public static void writeCsv(String filename, String[] headers, List<Map<String, String>> list, boolean append) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, append)));
		ICsvMapWriter writer = new CsvMapWriter(bw, CsvPreference.EXCEL_PREFERENCE);
		// 不是追加，写头
		if (!append) {
			writer.writeHeader(headers);
		}
		if (null != list) {
			for (Map<String, String> map : list) {
				writer.write(map, headers);
			}
		}
		writer.flush();
		writer.close();
		bw.close();
	}

	/**
	 * 
	 * @Title: readCsv
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param filename
	 * @throws Exception
	 * @return void
	 * @date 2015年7月9日 下午4:51:56
	 * @throws
	 */
	public static List<Map<String, String>> readCsv(String filename) throws Exception {
		InputStream in = ClassLoader.getSystemResourceAsStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		ICsvMapReader reader = new CsvMapReader(br, CsvPreference.EXCEL_PREFERENCE);
		// 获取头部信息
		String[] headers = reader.getHeader(true);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		while ((map = reader.read(headers)) != null) {
			list.add(map);
		}
		reader.close();
		br.close();
		in.close();
		return list;
	}

}
