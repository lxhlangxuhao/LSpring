package com.hao.xu.lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:34 2019/6/9
 */

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

	String value();
	String ORACLE = "oracleAtomikosDataSource";
	String MYSQL = "mysqlAtomikosDataSource";

}