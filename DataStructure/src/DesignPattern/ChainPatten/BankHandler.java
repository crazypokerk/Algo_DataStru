package DesignPattern.ChainPatten;


/**
 * @Date 2019/4/16 19:50
 */
public abstract class BankHandler {
	//不同的货币
	public final static int RMB_LEVEL_REQUEST = 1;
	public final static int USD_LEVEL_REQUEST = 2;
	public final static int EUR_LEVEL_REQUEST = 3;
	public final static int JPY_LEVEL_REQUEST = 4;
	
	//能处理的级别
	private int level = 0;
	
	//责任传递，下一个责任处理是谁
	private BankHandler nextHandler;
	
	public BankHandler(int level) {
		this.level = level;
	}
	
	//某一种货币（人民币、美元、欧元、日元）要求存入银行，要处理这个请求
	public final void HandleMessage(IMoney money) {
		if (money.getType() == this.level) {
			this.response(money);
		} else {
			if (this.nextHandler != null) {
				this.nextHandler.HandleMessage(money);
			} else {
				System.out.println("*******************************");
				System.out.println("---处理不了的货币，按不处理对待！---");
				System.out.println("*******************************");
			}
		}
	}
	
	//如果处理不了这个，告知下一个处理人
	public void setNext(BankHandler handler) {
		this.nextHandler = handler;
	}
	
	//有请求当然要回应
	protected abstract void response(IMoney money);
}
