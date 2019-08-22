package DesignPattern.SingletonPattern.EnumSingleton;

/**
 * @Date 2019/4/24 18:22
 */
public class Main {
	public static void main(String[] args) {
		MYSQLConnection c1 = SingletonOfEnum.DATASOURCE.getConnection();
		MYSQLConnection c2 = SingletonOfEnum.DATASOURCE.getConnection();
		MYSQLConnection c3 = SingletonOfEnum.DATASOURCE.getConnection();
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		System.out.println(c2 == c3);
	}
}
