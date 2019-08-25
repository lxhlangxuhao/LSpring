package com.hao.xu.lang.entity;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:24 2019/6/9
 */
public class User {


	private int id;
	public String name;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				", score=" + score +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (score != user.score) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		return department != null ? department.equals(user.department) : user.department == null;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (department != null ? department.hashCode() : 0);
		result = 31 * result + score;
		return result;
	}
}
