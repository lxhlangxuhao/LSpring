package com.hao.xu.lang.entity;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:24 2019/6/9
 */
public class User {

	private int id;
	private String name;
	private String department;
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
