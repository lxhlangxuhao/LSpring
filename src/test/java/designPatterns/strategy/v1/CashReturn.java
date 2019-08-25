package designPatterns.strategy.v1;

/**
 * @Author: Xuhao
 * @Description: 正常消费类
 * @Date: Created in 21:09 2019/8/25
 */
public class CashReturn implements CashSuper {

	private int moneyCondition;  // 满足金额

	private int moneyRetrun;  // 满减金额

	public CashReturn(int moneyCondition, int moneyRetrun) {
		this.moneyCondition = moneyCondition;
		this.moneyRetrun = moneyRetrun;
	}

	@Override
	public double acceptCash(double money) {

		if (money >= moneyCondition)
			return money - Math.floor(money / moneyCondition) * moneyRetrun;
		return money;
	}

	public static void main(String[] args) {

		System.out.println(new CashNormal().acceptCash(100));
		System.out.println(new CashReturn(300, 100).acceptCash(500));
		System.out.println(new CashDiscount(0.8).acceptCash(100));
	}
}
