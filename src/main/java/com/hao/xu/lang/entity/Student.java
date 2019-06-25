package com.hao.xu.lang.entity;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 20:03 2019/3/3
 */
public class Student {

	private String name;
	private int score;

	public Student(){

	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "[姓名=" + name + ", 分数=" + score + "]";
	}

}
