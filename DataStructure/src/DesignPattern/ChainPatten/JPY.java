package DesignPattern.ChainPatten;

/**
 * @Date 2019/4/16 20:09
 */
public class JPY extends BankHandler {
	public JPY() {
		super(BankHandler.JPY_LEVEL_REQUEST);
	}
	
	@Override
	protected void response(IMoney money) {
		System.out.println("---我存JPY，帮我存入日元账户---");
		System.out.println(money.getRequest());
		System.out.println("JPY处理完成，账户余额：円55555");
	}
}
