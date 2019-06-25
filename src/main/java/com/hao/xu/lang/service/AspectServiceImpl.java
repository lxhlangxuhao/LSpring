package com.hao.xu.lang.service;

import org.springframework.stereotype.Service;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:00 2019/6/4
 */
@Service
public class AspectServiceImpl implements AspectService{

	@Override
	public String hiAspect(String name) {
		System.out.println("hi");
		return "123";
	}
}
