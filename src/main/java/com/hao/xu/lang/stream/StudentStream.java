package com.hao.xu.lang.stream;

import com.hao.xu.lang.entity.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Xuhao
 * @Description:
 */
public class StudentStream {


	public static void main(String[] args) {

		//获取数据
		List<Student> studentList = getInitData();

		//需求1：列出90分以上的学生姓名，并按照分数降序排序
		List<Student> list1 = studentList.stream().filter(student -> student.getScore() > 90).sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
		list1.forEach(System.out::println);

		//需求2：使用map方法获取list数据中的name
		List<String> list2 = studentList.stream().map(Student::getName).collect(Collectors.toList());
		list2.forEach(System.out::println);

		//需求3：使用map方法获取list数据中的name的长度
		List<Integer> list3 = studentList.stream().map(student -> student.getName().length()).collect(Collectors.toList());
		//or
		List<Integer> list33 = studentList.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
		list3.forEach(System.out::println);

		//需求4：将每人的分数-10
		List<Integer> list4 = studentList.stream().map(student -> student.getScore() - 10).collect(Collectors.toList());
		list4.forEach(System.out::println);

		//需求5：计算学生总分
		int sum = studentList.stream().mapToInt(Student::getScore).sum();
		System.out.println(sum);

		//需求6：计算平均分
		OptionalDouble average = studentList.stream().mapToInt(Student::getScore).average();
		System.out.println(average.getAsDouble());

		//数组创建流的方式
		String[] strArr = {"a","b","c"};
		Stream<String> stream = Arrays.stream(strArr);
		//and
		Stream<String> str =  Stream.of("i","love","this","game");

		//集合创建流的方式
		Stream<Student> streamList = studentList.stream();




	}
















	public static List<Student> getInitData() {
		List<Student> stuList = new ArrayList<>(10);
		stuList.add(new Student("刘一", 85));
		stuList.add(new Student("陈二", 90));
		stuList.add(new Student("张三", 98));
		stuList.add(new Student("李四", 88));
		stuList.add(new Student("王五", 83));
		stuList.add(new Student("赵六", 95));
		stuList.add(new Student("孙七", 87));
		stuList.add(new Student("周八", 84));
		stuList.add(new Student("吴九", 100));
		stuList.add(new Student("郑十", 95));

		return stuList;
	}

}
