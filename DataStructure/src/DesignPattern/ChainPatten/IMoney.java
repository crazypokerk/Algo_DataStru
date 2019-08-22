package DesignPattern.ChainPatten;

public interface IMoney {
	//获得货币类型
	int getType();
	
	//获得货币处理请求
	String getRequest();
}
