package DesignPattern.ChainPatten;

/**
 * @Date 2019/4/16 20:04
 */
public class RMB extends BankHandler {
	public RMB() {
		super(BankHandler.RMB_LEVEL_REQUEST);
	}
	
	@Override
	protected void response(IMoney money) {
		System.out.println("---我存RMB，帮我存入人民币账户---");
		System.out.println(money.getRequest());
		System.out.println("RMB处理完成，账户余额：￥66666");
	}
}
