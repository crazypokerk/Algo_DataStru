package DesignPattern.GongChangMoShi;

/**
 * @Date 2019/4/4 9:46
 */
public class Factory {
	public static Animal getInstance(String className) {
		Animal animal = null;
		if ("Cat".equals(className)) {
			animal = new Cat();
		}
		if ("Dog".equals(className)) {
			animal = new Dog();
		}
		return animal;
	}
}
