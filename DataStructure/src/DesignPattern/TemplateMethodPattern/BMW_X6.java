package DesignPattern.TemplateMethodPattern;

/**
 * @Date 2019/4/4 11:15
 */
public class BMW_X6 extends AbstractClass {
	//宝马X6鸣笛声是哔哔
	@Override
	protected void alarm() {
		System.out.println("哔哔！老子是宝马X6！");
	}
	
	//宝马X6引擎轰轰响
	@Override
	protected void engineBoom() {
		System.out.println("轰~~~");
	}
	
	@Override
	protected void start() {
		System.out.println("宝马X6走了啊！");
	}
}
