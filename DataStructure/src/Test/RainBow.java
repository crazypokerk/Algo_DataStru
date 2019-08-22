package Test;

/**
 * @Date 2019/5/27 14:01
 */
public class RainBow implements Comparable {
	private int age;
	private String name;
	
	public RainBow(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Object o) {
		RainBow rainBow = (RainBow) o;
		if (this.age > rainBow.age) {
			return 1;
		} else if (this.age < rainBow.age) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	private static abstract class inner {
	
	}
}
