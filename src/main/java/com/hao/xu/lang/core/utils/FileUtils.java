package com.hao.xu.lang.core.utils;

import java.text.DecimalFormat;

/**
 * @Author: Xuhao
 * @Description: 文件工具类
 * @Date: Created in 9:18 2019/6/27
 */
public class FileUtils {

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


	public static void main(String[] args) {
		System.out.println(getFileSizeDescription(102500000000L));
	}
}
