package DesignPattern.TemplateMethodPattern;

/**
 * @Date 2019/4/4 11:11
 */
public abstract class AbstractClass {
	//鸣笛声音
	protected abstract void alarm();
	
	//发动机声音
	protected abstract void engineBoom();
	
	//启动汽车
	protected abstract void start();
	
	//模板方法
	public void templateMethod() {
		this.alarm();
		this.engineBoom();
		this.start();
	}
}
