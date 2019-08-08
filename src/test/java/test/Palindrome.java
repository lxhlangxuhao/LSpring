package test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:58 2019/7/3
 */
public class Palindrome {

	public static void main(String[] args) {

		int a = 12312;
		System.out.println(isPalindrome(a));

	}
	private static boolean isPalindrome(int num) {
		if (num < 0 || (num % 10) == 0 && num != 0) {  // 负数 || 末尾是0且不为0,
			return false;
		}
		int reverseNum = 0; // 反转后的数字
		int tempNum = num; // 临时用于反转

		while (tempNum != 0) {
			int fristNum = tempNum % 10; //取到首位
			tempNum /= 10;
			reverseNum = reverseNum * 10 + fristNum;
		}
		return reverseNum == num;
	}
}
