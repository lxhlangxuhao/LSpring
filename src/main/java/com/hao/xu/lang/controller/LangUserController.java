package com.hao.xu.lang.controller;

import com.google.gson.Gson;
import com.hao.xu.lang.annotation.ExcludeInterceptor;
import com.hao.xu.lang.service.TestService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:48 2019/6/9
 */
@RestController
@RequestMapping(value = "/langUserController")
public class LangUserController {

	@Resource
	private TestService testService;

	@RequestMapping(value = "/findLangUserById")
	@ExcludeInterceptor
	public String findLangUserById(@RequestParam(value = "id", required = false,defaultValue = "1") Integer id) {

		testService.test();

		return new Gson().toJson("ss");
	}


	@RequestMapping(value = "/findLangUserById2")
	@ExcludeInterceptor
	public String findLangUserById2(@RequestParam(value = "id", required = false,defaultValue = "1") Integer id) {

		testService.test2();

		return new Gson().toJson("ss");
	}


}
