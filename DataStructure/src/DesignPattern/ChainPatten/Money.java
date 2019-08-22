package DesignPattern.ChainPatten;

/**
 * @Date 2019/4/16 19:54
 */
public class Money implements IMoney {
	/*
		通过一个int类型参数来描述货币的类型
		1：人民币
		2：美元
		3：欧元
		4：日元
	 */
	private int type = 0;
	//货币的处理请求
	private String request = "";
	
	//构造函数传递过来请求
	public Money(int type, String request) {
		this.type = type;
		//为了便于显示，在这里做了点处理
		switch (this.type) {
			case 1:
				this.request = "人民币请求是：" + request;
				break;
			case 2:
				this.request = "美元请求是：" + request;
				break;
			case 3:
				this.request = "欧元请求是：" + request;
				break;
			case 4:
				this.request = "日元请求是：" + request;
		}
	}
	
	//获得货币的类型
	public int getType() {
		return type;
	}
	
	//获得货币的处理请求
	public String getRequest() {
		return request;
	}
}
