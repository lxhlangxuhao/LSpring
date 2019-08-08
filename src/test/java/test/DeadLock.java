package test;

/**
 * @Author: Xuhao
 * @Description: 死锁
 * @Date: Created in 22:08 2019/7/2
 */
public class DeadLock {

	private static final Object lockOne = new Object();
	private static final Object lockTwo = new Object();
	private static void run() {
		new Thread(() ->{
			synchronized (lockOne) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lockTwo) {
				}
			}
		}).start();

		new Thread(() ->{
			synchronized (lockTwo) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lockOne) {
				}
			}
		}).start();
	}


	public static void main(String[] args) {
		run();
	}
}
