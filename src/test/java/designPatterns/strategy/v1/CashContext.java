package designPatterns.strategy.v1;

/**
 * @Author: Xuhao
 * @Description: 环境配置类
 * @Date: Created in 21:42 2019/8/25
 */
public class CashContext {

	private CashSuper cashSuper;

	public CashContext(CashSuper cashSuper) {
		this.cashSuper = cashSuper;
	}

	public double getResult(double money) {

		return cashSuper.acceptCash(money);
	}

	public static void main(String[] args) {

		CashContext cashContext = new CashContext(new CashReturn(300, 150));
		System.out.println(cashContext.getResult(300));

	}
}
