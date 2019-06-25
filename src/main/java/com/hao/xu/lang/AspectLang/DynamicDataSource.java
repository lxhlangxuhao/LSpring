package com.hao.xu.lang.AspectLang;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 1:05 2019/6/16
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// 从自定义的位置获取数据源标识
		System.out.println("当前数据库源：" + DynamicDataSourceHolder.getDataSource());
		return DynamicDataSourceHolder.getDataSource();
	}

}