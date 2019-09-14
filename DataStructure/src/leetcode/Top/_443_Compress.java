package leetcode.Top;

/**
 * @Date 2019/9/14 16:07
 */
public class _443_Compress {
	
	public static int compress(char[] chars) {
		int i = 0;
		int size = 0;
		for (int j = 0; j <= chars.length; j++) {
			if (j == chars.length || chars[j] != chars[i]) {
				chars[size++] = chars[i];
				if (j - i > 1) {
					for (char c : String.valueOf(j - i).toCharArray()) {
						chars[size++] = c;
					}
				}
				i = j;
			}
		}
		return size;
	}
	
	public static void main(String[] args) {
		char[] c = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		System.out.println(compress(c));
	}
	
}
