package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/7/28 10:19
 */
public class TestFanxing {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
		
		int[] a = {1, 23, 2, 32};
		int[] b = {123, 3231, 32};
		
		list.add(a);
		list.add(b);
		
		System.out.println(list);
		
		String sad = anInt(123, "sad", 123.9, list, a);
		System.out.println(sad);
	}
	
	public <s> short sad(s t) {
		return 1;
	}
	
	public static <T, M, L, K, B> String anInt(T t, M m, L l, K k, B b) {
		t.toString();
		m.toString();
		l.toString();
		k.toString();
		b.toString();
		
		return String.valueOf(t) + String.valueOf(m) + String.valueOf(l) + String.valueOf(k);
	}
}


