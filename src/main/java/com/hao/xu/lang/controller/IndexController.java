package com.hao.xu.lang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:30 2019/6/16
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public ModelAndView indexPage() {
		System.out.println();
		return new ModelAndView("hello");
	}
}

