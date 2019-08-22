package DesignPattern.TemplateMethodPattern;

/**
 * @Date 2019/4/4 11:17
 */
public class Client {
	public static void main(String[] args) {
		AbstractClass x4 = new BMW_X4();
		AbstractClass x6 = new BMW_X6();
		//调用模板方法
		x4.templateMethod();
		x6.templateMethod();
	}
}
