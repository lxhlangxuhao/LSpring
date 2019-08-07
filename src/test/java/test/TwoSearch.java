package test;

import java.util.TimerTask;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:32 2019/7/4
 */
public class TwoSearch extends TimerTask {

	public int search(int[] nums, int target) {
		if (nums == null) {
			return -1;
		}
		int startIdx = 0;
		int endIdx = nums.length - 1;
		int middle = 0;
		while (startIdx <= endIdx) {
			middle = (startIdx + endIdx) / 2;

			if (nums[middle] == target) {
				return middle;
			}
			if (target < nums[middle]) {
				endIdx = middle - 1;
			} else if (target > nums[middle]) {
				startIdx = middle + 1;
			}
		}

		return -1;
	}
	static int a = 10;
	public static void main(String[] args) {



		new Thread(() ->{

			synchronized (TwoSearch.class) {

				try {
					Thread.sleep(5000);
					a = 100;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}).start();

		try {
			Thread.sleep(1000);
			System.out.println(a);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void run() {

	}
}