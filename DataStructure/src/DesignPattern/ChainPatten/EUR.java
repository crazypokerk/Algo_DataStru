package DesignPattern.ChainPatten;

/**
 * @Date 2019/4/16 20:08
 */
public class EUR extends BankHandler {
	public EUR() {
		super(BankHandler.EUR_LEVEL_REQUEST);
	}
	
	@Override
	protected void response(IMoney money) {
		System.out.println("---我存EUR，帮我存入欧元账户---");
		System.out.println(money.getRequest());
		System.out.println("EUR处理完成，账户余额： €77777");
	}
}
