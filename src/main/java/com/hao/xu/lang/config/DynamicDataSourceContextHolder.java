package com.hao.xu.lang.config;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:42 2019/6/9
 */
public class DynamicDataSourceContextHolder {

	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

	/**
	 * @param dataSourceType 数据库类型
	 * @return void
	 * @throws
	 * @Description: 设置数据源类型
	 */
	public static void setDataSourceType(String dataSourceType) {
		CONTEXT_HOLDER.set(dataSourceType);
	}

	/**
	 * @param
	 * @return String
	 * @throws
	 * @Description: 获取数据源类型
	 */
	public static String getDataSourceType() {
		return CONTEXT_HOLDER.get();
	}

	/**
	 * @param
	 * @return void
	 * @throws
	 * @Description: 清除数据源类型
	 */
	public static void clearDataSourceType() {
		CONTEXT_HOLDER.remove();
	}
}