package com.hao.xu.lang.controller;

import com.google.gson.Gson;
import com.hao.xu.lang.entity.User;
import core.BaseJunitTest;
import core.BaseMockMvcJunitTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 20:45 2019/6/24
 */
@WebAppConfiguration
@Transactional
public class MockMvcTest extends BaseMockMvcJunitTest {

	@Test
	public void testGet() {
	/*
		@RequestMapping(value = "/testGet",method = RequestMethod.GET)
		@ResponseBody
		public String testGet(String name, String age) {
			return name+":"+age;
		}
	*/
		try {
			MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.get("/hello/testGet")//Get 请求
//							.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//							.accept(MediaType.APPLICATION_JSON)
							.param("name", "小狼")//设置参数
							.param("age", "26")
			)
					.andExpect(MockMvcResultMatchers.status().is(200))//设置返回状态200
					.andDo(MockMvcResultHandlers.print())//控制台打印出请求和相应的内容
					.andReturn();
			String resultStr = mvcResult.getResponse().getContentAsString();//将相应的数据转换为字符串
			String name = mvcResult.getRequest().getParameter("name");
			String age = mvcResult.getRequest().getParameter("age");

			System.out.println(resultStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPost() {
	/*
		@RequestMapping(value = "/testPost",method = RequestMethod.POST)
		@ResponseBody
		public String testPost(String name, String age) {

			return "testPost";
		}
	*/
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/hello/testPost")
				.param("name", "小狼")
				.param("age", "18");

		try {
			MvcResult mvcResult = mockMvc.perform(request)
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andDo(MockMvcResultHandlers.print())//控制台打印出请求和相应的内容
					.andReturn();
			String resultStr = mvcResult.getResponse().getContentAsString();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testPostEntity() {

		/*
			@RequestMapping(value = "/testPostEntity",method = RequestMethod.POST)
			@ResponseBody
			public String testPostEntity(User user) {

				return user.toString();
			}
		*/

		//准备数据
		User user = new User();
		user.setId(50);
		user.setName("小狼");
		user.setDepartment("IT");
		user.setScore(99);
		System.out.println(user.toString());
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/hello/testPostEntity")
				.param("id", "50")
				.param("name", "小狼")
				.param("department", "IT")
				.param("score", "99");


		try {
			MvcResult mvcResult = mockMvc.perform(request)
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andDo(MockMvcResultHandlers.print())//控制台打印出请求和相应的内容
					.andReturn();
			System.out.println(mvcResult.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
