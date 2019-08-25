package com.hao.xu.lang.core.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @Author: Xuhao
 * @Description: 文件工具类
 * @Date: Created in 9:18 2019/6/27
 */
public class FileUtils {

	/**
	 * @Author: LangXuhao
	 * @Description: 文件大小转成描述 1.00 B/2.00 KB/3.00 MB /4.00 G
	 * @param size long
	 * @return: java.lang.String
	 */
	public static String getFileSizeDescription(long size) {
		StringBuilder bytes = new StringBuilder();
		DecimalFormat format = new DecimalFormat("###.00");
		if (size <= 0) {
			bytes.append("0 B");
		}
		else if (size < 1024) {
			bytes.append((int) size).append(" B");
		}
		else if (size >= 1024 * 1024 * 1024) {
			double i = (size / (1024.0 * 1024.0 * 1024.0));
			bytes.append(format.format(i)).append(" GB");
		}
		else if (size >= 1024 * 1024) {
			double i = (size / (1024.0 * 1024.0));
			bytes.append(format.format(i)).append(" MB");
		}
		else if (size >= 1024) {
			double i = (size / (1024.0));
			bytes.append(format.format(i)).append(" KB");
		}
		return bytes.toString();
	}


	/**
	 * @Author: LangXuhao
	 * @Description: 创建不存在文件
	 * @param file File
	 * @return: boolean 创建成功ture
	 */
	public static boolean createFile(File file) {
		if (!file.exists()) {
			try {
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
