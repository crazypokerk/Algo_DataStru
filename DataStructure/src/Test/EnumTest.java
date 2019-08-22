package Test;

/**
 * @Date 2019/5/28 13:00
 */
public enum EnumTest {
	
	MONDAY(1), TUESDAY(2), WEDNESDAY(3),
	THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
	
	private final int numOfMeans;
	
	private EnumTest(int n) {
		numOfMeans = n;
	}
	
	public int getNumOfMeans() {
		return numOfMeans;
	}
}

class main {
	public static void main(String[] args) {
		System.out.println(EnumTest.SATURDAY);
		
		System.out.println(EnumTest.SUNDAY.getNumOfMeans());
	}
}
