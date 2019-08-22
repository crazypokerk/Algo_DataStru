package Test;

import java.util.Scanner;

/**
 * @Date 2019/8/6 19:27
 */
public class maintest {
	
	protected static final String[] UNITS = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千",};
	protected static final String[] NUMS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九",};
	
	public static String translate(int value) {
		if (value < 0) {
			return null;
		}
		
		String result = "";
		for (int i = String.valueOf(value).length() - 1; i >= 0; i--) {
			int r = (int) (value / Math.pow(10, i));
			result += NUMS[r % 10] + UNITS[i];
		}
		result = result.replaceAll("零[十, 百, 千]", "零");
		result = result.replaceAll("零+", "零");
		result = result.replaceAll("零([万, 亿])", "$1");
		result = result.replaceAll("亿万", "亿");
		if (result.startsWith("一十"))
			result = result.substring(1);
		if (result.endsWith("零")) {
			result = result.substring(0, result.length() - 1);
			
		}
		return result.trim();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = translate(n);
		System.out.print(str);
	}
}
