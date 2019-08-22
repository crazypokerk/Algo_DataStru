package DesignPattern.GongChangMoShi;

/**
 * @Date 2019/4/4 9:48
 */
public class GongChang {
	public static void main(String[] args) {
		Animal animal = null;
		animal = Factory.getInstance(args[0]);
		if (animal != null) {
			animal.say();
		}
	}
}
