package test;

import java.util.Arrays;

/**
 * @Author: Xuhao
 * @Description: 冒泡
 * @Date: Created in 22:27 2019/7/2
 */
public class Bubble {

	public static void main(String[] args) {

		//冒泡
		int[] intArr = {4, 2, 5, 1};
		for (int i = 0; i < intArr.length - 1; i++) {
			for (int j = 0; j < intArr.length - 1 - i; j++) {
				if (intArr[j] > intArr[j+1]) {
					int temp = intArr[j];
					intArr[j] = intArr[j + 1];
					intArr[j + 1] = temp;
				}
			}
		}

		//选择
		for (int i = 0; i < intArr.length - 1; i++) {
			for (int j = i + 1; j < intArr.length; j++) {
				if (intArr[i] > intArr[j]) {
					int temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
		}




		System.out.println(Arrays.toString(intArr));
	}





}
