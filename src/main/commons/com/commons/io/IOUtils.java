/**    
 * @Title: IOUtils.java  
 * @Package com.commons.io  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月11日 下午9:34:13 
 * @version V1.0   
 */
package com.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.monitor.FileEntry;

/**
 * @ClassName: IOUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年6月11日 下午9:34:13
 * 
 */
public class IOUtils {

	/**
	 * @throws IOException
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param args
	 * @return void
	 * @date 2015年6月11日 下午9:34:13
	 * @throws
	 */
	public static void main(String[] args) throws IOException {
		// FilenameUtils demo
		// filenameUtils();

		// fileMonitor();

		filters();
	}

	
	/**
	 * 
	 * @Title: filters 
	 * @Description: TODO(filters)  
	 * @author frinder_liu 
	 * @return void
	 * @date 2015年6月11日 下午10:47:13
	 * @throws
	 */
	public static void filters() {
		String PARENT_DIR = "D:\\LEARN\\apache-commons-demo\\filemonitor";

		System.out.println("File Filter example...");

		// NameFileFilter
		// Right now, in the parent directory we have 3 files:
		// directory example
		// file exampleEntry.txt
		// file exampleTxt.txt

		// Get all the files in the specified directory
		// that are named "hello".
		File dir = FileUtils.getFile(PARENT_DIR);

		String[] acceptedNames = { "hello", "hello.txt" };
		for (String file : dir.list(new NameFileFilter(acceptedNames, IOCase.INSENSITIVE))) {
			System.out.println("File found, named: " + file);
		}

		// WildcardFileFilter
		// We can use wildcards in order to get less specific results
		// ? used for 1 missing char
		// * used for multiple missing chars
		for (String file : dir.list(new WildcardFileFilter("*he*"))) {
			System.out.println("Wildcard file found, named: " + file);
		}

		// PrefixFileFilter
		// We can also use the equivalent of startsWith
		// for filtering files.
		for (String file : dir.list(new PrefixFileFilter("he"))) {
			System.out.println("Prefix file found, named: " + file);
		}

		// SuffixFileFilter
		// We can also use the equivalent of endsWith
		// for filtering files.
		for (String file : dir.list(new SuffixFileFilter(".txt"))) {
			System.out.println("Suffix file found, named: " + file);
		}

		// OrFileFilter
		// We can use some filters of filters.
		// in this case, we use a filter to apply a logical
		// or between our filters.
		for (String file : dir.list(new OrFileFilter(new WildcardFileFilter("*he*"), new SuffixFileFilter(".txt")))) {
			System.out.println("Or file found, named: " + file);
		}

		// And this can become very detailed.
		// Eg, get all the files that have "ample" in their name
		// but they are not text files (so they have no ".txt" extension.
		for (String file : dir.list(new AndFileFilter(new WildcardFileFilter("*he*"), new NotFileFilter(new SuffixFileFilter(".log"))))) {
			System.out.println("And/Not file found, named: " + file);
		}
	}

	/**
	 * 
	 * @Title: fileMonitor
	 * @Description: TODO(fileMonitor)
	 * @author frinder_liu
	 * @return void
	 * @date 2015年6月11日 下午10:36:33
	 * @throws
	 */
	public static void fileMonitor() {

		String EXAMPLE_PATH = "D:\\LEARN\\apache-commons-demo\\filemonitor\\hello.txt";

		String PARENT_DIR = "D:\\LEARN\\apache-commons-demo\\filemonitor";

		String NEW_DIR = "D:\\LEARN\\apache-commons-demo\\filemonitor\\newDir";

		String NEW_FILE = "D:\\LEARN\\apache-commons-demo\\filemonitor\\hello-new.txt";

		System.out.println("File Monitor example...");

		// FileEntry

		// We can monitor changes and get information about files
		// using the methods of this class.
		FileEntry entry = new FileEntry(FileUtils.getFile(EXAMPLE_PATH));

		System.out.println("File monitored: " + entry.getFile());
		System.out.println("File name: " + entry.getName());
		System.out.println("Is the file a directory?: " + entry.isDirectory());

		// File Monitoring

		// Create a new observer for the folder and add a listener
		// that will handle the events in a specific directory and take action.
		File parentDir = FileUtils.getFile(PARENT_DIR);

		FileAlterationObserver observer = new FileAlterationObserver(parentDir);
		observer.addListener(new FileAlterationListenerAdaptor() {

			@Override
			public void onFileCreate(File file) {
				System.out.println("File created: " + file.getName());
			}

			@Override
			public void onFileDelete(File file) {
				System.out.println("File deleted: " + file.getName());
			}

			@Override
			public void onDirectoryCreate(File dir) {
				System.out.println("Directory created: " + dir.getName());
			}

			@Override
			public void onDirectoryDelete(File dir) {
				System.out.println("Directory deleted: " + dir.getName());
			}
		});

		// Add a monior that will check for events every x ms,
		// and attach all the different observers that we want.
		FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);
		try {
			monitor.start();

			// After we attached the monitor, we can create some files and
			// directories
			// and see what happens!
			File newDir = new File(NEW_DIR);
			File newFile = new File(NEW_FILE);

			newDir.mkdirs();
			newFile.createNewFile();

			Thread.sleep(1000);

			FileDeleteStrategy.NORMAL.delete(newDir);
			FileDeleteStrategy.NORMAL.delete(newFile);

			Thread.sleep(1000);

			monitor.stop();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * FilenameUtils
	 */
	public static void filenameUtils() throws IOException {
		String basePath = "D:\\logs\\spring-mvc\\";
		String fileName = "file.log";
		String fullFileName = basePath + fileName;

		System.out.println("1、显示linux路径:" + FilenameUtils.normalizeNoEndSeparator(fullFileName, true));
		System.out.println("2、合并目录和文件名为文件全路径:" + FilenameUtils.concat(basePath, fileName));
		System.out.println("3、文件路径去除目录和后缀后的文件名:" + FilenameUtils.getBaseName(fullFileName));
		System.out.println("4、获取文件的后缀:" + FilenameUtils.getExtension(fullFileName));
		System.out.println("5、获取文件的目录:" + FilenameUtils.getFullPath(fullFileName));
		System.out.println("6、获取文件的目录不包含结束符:" + FilenameUtils.getFullPathNoEndSeparator(fullFileName));
		System.out.println("7、获取文件名称，包含后缀:" + FilenameUtils.getName(fullFileName));
		System.out.println("8、去除前缀的路径:" + FilenameUtils.getPath(fullFileName));
		System.out.println("9、去除前缀并结尾去除分隔符:" + FilenameUtils.getPathNoEndSeparator(fullFileName));
		System.out.println("10、获取前缀:" + FilenameUtils.getPrefix(fullFileName));
		System.out.println("11、获取前缀长度:" + FilenameUtils.getPrefixLength(fullFileName));
		System.out.println("12、获取最后一个.的位置:" + FilenameUtils.indexOfExtension(fullFileName));
		System.out.println("13、获取最后一个/的位置:" + FilenameUtils.indexOfLastSeparator(fullFileName));
		System.out.println("14、获取当前系统格式化路径:" + FilenameUtils.normalize(fullFileName));
		System.out.println("15、获取linux系统格式化路径:" + FilenameUtils.normalize(fullFileName, true));
		System.out.println("16、获取当前系统无结尾分隔符的路径:" + FilenameUtils.normalizeNoEndSeparator(basePath));
		System.out.println("17、获取linux系统无结尾分隔符的路径:" + FilenameUtils.normalizeNoEndSeparator(basePath, true));
		System.out.println("18、移除文件的扩展名:" + FilenameUtils.removeExtension(fullFileName));
		System.out.println("19、转换分隔符为当前系统分隔符:" + FilenameUtils.separatorsToSystem(fullFileName));
		System.out.println("20、转换分隔符为linux系统分隔符:" + FilenameUtils.separatorsToUnix(fullFileName));
		System.out.println("21、转换分隔符为windows系统分隔符:" + FilenameUtils.separatorsToWindows(fullFileName));
		System.out.println("22、判断目录下是否包含指定文件或目录:" + FilenameUtils.directoryContains(basePath, fullFileName));
		String linuxFileName = FilenameUtils.normalize(fullFileName, true);
		System.out.println("23、判断文件路径是否相同，非格式化:" + FilenameUtils.equals(fullFileName, linuxFileName));
		System.out.println("24、判断文件路径是否相同，格式化并大小写不敏感:" + FilenameUtils.equals(fullFileName, FilenameUtils.normalize(fullFileName, true), true, IOCase.INSENSITIVE));
		System.out.println("25、判断文件路径是否相同，格式化并大小写敏感:" + FilenameUtils.equalsNormalized(fullFileName, linuxFileName));
		System.out.println("26、判断文件路径是否相同，不格式化，大小写敏感根据系统规则：windows：敏感；linux：不敏感:" + FilenameUtils.equalsOnSystem(fullFileName, linuxFileName));
		Collection<String> extensions = new ArrayList<String>();
		extensions.add("txt");
		extensions.add("java");
		System.out.println("27、判断文件扩展名是否包含在指定集合中:" + FilenameUtils.isExtension(fullFileName, extensions));
		System.out.println("28、判断文件扩展名是否等于指定扩展名:" + FilenameUtils.isExtension(fullFileName, "txt"));
		System.out.println("29、判断文件扩展名是否包含在指定字符串数组中:" + FilenameUtils.isExtension(fullFileName, new String[] { "txt", "java" }));
		System.out.println("30、判断文件扩展名是否和指定规则匹配，大小写敏感:" + FilenameUtils.wildcardMatch(fileName, "*.???"));
		System.out.println("31、判断文件扩展名是否和指定规则匹配，大小写不敏感:" + FilenameUtils.wildcardMatch(fileName, "*.???", IOCase.INSENSITIVE));
		System.out.println("32、判断文件扩展名是否和指定规则匹配，根据系统判断敏感型：windows:不敏感；linux：敏感:" + FilenameUtils.wildcardMatchOnSystem(fileName, "*.???"));

	}

}
