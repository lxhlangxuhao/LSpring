package designPatterns.strategy.v1;

/**
 * @Author: Xuhao
 * @Description: 环境配置类
 * @Date: Created in 21:42 2019/8/25
 */
public class CashContextV2 {

	private CashSuper cashSuper;

	public CashContextV2(String type) {

		switch (type) {
			case "0":
				cashSuper = new CashNormal();
			break;
			case "1":
				cashSuper = new CashDiscount(0.8);
				break;
			case "2":
				cashSuper = new CashReturn(300, 100);
				break;
		}
	}

	public double getResult(double money) {

		return cashSuper.acceptCash(money);
	}

	public static void main(String[] args) {

		System.out.println(new CashContextV2("0").getResult(300));
		System.out.println(new CashContextV2("1").getResult(300));
		System.out.println(new CashContextV2("2").getResult(300));



	}
}
