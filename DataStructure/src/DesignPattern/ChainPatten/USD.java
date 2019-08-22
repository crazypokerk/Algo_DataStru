package DesignPattern.ChainPatten;

/**
 * @Date 2019/4/16 20:06
 */
public class USD extends BankHandler {
	public USD() {
		super(BankHandler.USD_LEVEL_REQUEST);
	}
	
	@Override
	protected void response(IMoney money) {
		System.out.println("---我存USD，帮我存入美元账户---");
		System.out.println(money.getRequest());
		System.out.println("USD处理完成，账户余额 :$88888");
	}
}
