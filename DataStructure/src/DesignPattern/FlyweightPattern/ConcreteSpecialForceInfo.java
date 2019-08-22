package DesignPattern.FlyweightPattern;

/**
 * @Date 2019/4/15 13:47
 */
public class ConcreteSpecialForceInfo extends SpecialForceInfo {
	//定义一个对象池提取KEY的值
	private String key;
	
	//构造函数获得相同标志
	public ConcreteSpecialForceInfo(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
}
