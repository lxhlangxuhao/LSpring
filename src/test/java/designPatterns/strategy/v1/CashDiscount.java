package designPatterns.strategy.v1;

/**
 * @Author: Xuhao
 * @Description: 正常消费类
 * @Date: Created in 21:09 2019/8/25
 */
public class CashDiscount implements CashSuper {

	private double discountMoney = 1D;

	public CashDiscount(double discountMoney) {
		this.discountMoney = discountMoney;
	}

	@Override
	public double acceptCash(double money) {
		return money * discountMoney;
	}
}
