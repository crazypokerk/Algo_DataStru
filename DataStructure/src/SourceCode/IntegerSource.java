package SourceCode;

/**
 * @Date 2019/6/24 11:23
 */
public class IntegerSource {
	public static void main(String[] args) {
		String s = "-1231230";
		int i = Integer.parseInt(s);
		System.out.println(i);
		int j = Integer.parseInt("+12312");
		System.out.println(j);
		
		int k = Integer.parseInt("-123123");
		System.out.println(k);
		
		int i1 = Integer.parseInt("11", 2);
		System.out.println(i1);
		
		Integer cache1 = 10;
		Integer cache2 = 10;
		
		//解码方法
		Integer decode = Integer.decode("0x7771");
		System.out.println(decode);
		
		System.out.println(cache1 == cache2);
		
		Integer x = new Integer(15);
		Integer y = Integer.valueOf(15);
		Integer z = Integer.valueOf(15);
		
		System.out.println(x == y);
		System.out.println(y == z);
	}
}
