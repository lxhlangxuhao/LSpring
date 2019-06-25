package com.hao.xu.lang.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Xuhao
 * @Description: 数据源动态切换
 * @Date: Created in 10:45 2019/6/9
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceType();
	}
}
