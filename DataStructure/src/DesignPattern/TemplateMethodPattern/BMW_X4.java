package DesignPattern.TemplateMethodPattern;

/**
 * @Date 2019/4/4 11:13
 */
public class BMW_X4 extends AbstractClass {
	//宝马X4鸣笛声是滴滴
	@Override
	protected void alarm() {
		System.out.println("滴滴！老子是宝马X4！");
	}
	
	//宝马X4引擎嗡嗡响
	@Override
	protected void engineBoom() {
		System.out.println("嗡~~~");
	}
	
	@Override
	protected void start() {
		System.out.println("宝马X4走了啊！");
	}
}
