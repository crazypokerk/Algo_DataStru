package SourceCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/6/24 9:18
 */
public class StringRead {
	public static void main(String[] args) {
		char[] c = {'a', 'b', 'c'};
		
		//String s = new String(c, -1, 1);
		
		//System.out.println(s);
		
		String sb = new String(new StringBuffer("a"));
		
		char c1 = sb.charAt(0);
		
		//此方法返回字符 ASCII 值
		int i = sb.codePointAt(0);
		
		System.out.println(i);
		
		String s1 = "abcccccaddsad";
		String s2 = "abccccaddsad";
		
		System.out.println(s1.equals(s2));
		// a 97 c 95 97 - 95 = 2
		System.out.println(s1.compareTo(s2));
		
		boolean ab = s1.startsWith("ab");
		System.out.println(ab);
		boolean d = s1.endsWith("d");
		System.out.println(d);
		
		//String 默认hash值为0
		System.out.println(sb.hashCode());
		
		//CharSequence delimiter, CharSequence... elements
		String java = String.join(":", "I", "Love", "Java");
		System.out.println(java);
		
		//CharSequence delimiter,Iterable<? extends CharSequence> elements
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		String join = String.join("-", list);
		System.out.println(join);
		
		String ii = "abc";
		String iii = ii.intern();
		String iiii = new String("abc");
		
		System.out.println(ii == iii);     //true
		System.out.println(ii == iiii);    //false
		System.out.println(iii == iiii);   //false
	}
}
