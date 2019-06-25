package com.hao.xu.lang.controller;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:50 2019/3/18
 */
public class ThreadTest {

	public static void main(String[] args) {

		RunTest runTest = new RunTest();

		//子线程执行50次
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				runTest.childThread(i);
			}
		}).start();

		//主线程执行50次
		for (int i = 0; i < 50; i++) {
			runTest.mainThread(i);
		}
	}
}

/**
 * 子线程执行10次，主线程执行100次，接着子线程再10次，主线程再执行100次，往复循环50次
 * */
class RunTest {

	private boolean flag = true;

	//子线程
	public synchronized void childThread(int index) {
		if (flag) {
			for (int i = 0; i < 10; i++) {
				System.out.println(index + "child index:" + i);
			}
			flag = false;
			//这个时候叫醒主线程去执行
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	//主线程
	public synchronized void mainThread(int index) {
		if (!flag) {
			for (int i = 0; i < 100; i++) {
				System.out.println(index + ":main index:" + i);
			}
			flag = true;
			//这个时候叫醒子线程去执行
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}



}
