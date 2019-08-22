package Test;

/**
 * @Date 2019/5/25 9:33
 */
public class StringIntern {
	public static void main(String[] args) {
//    String str1= "abc";
//    String str2= new String("abc");
//    String str3= str2.intern();
//    System.out.println(str1==str2);
//    System.out.println(str2==str3);
//    System.out.println(str1==str3);
//
//    String s = Integer.toString(1);
//    char[] c = s.toCharArray();
		
		char c = 'A';
		
		int a = 0;
		
		a ^= 1 << 5;
		
		c ^= 1 << 5;
		
		System.out.println(c);
		System.out.println(a);
	}
}
