package JianZhiOffer;

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @Date 2019/4/15 21:11
 */
public class FindNumsAppearOnce {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length <= 1 || array == null) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		
		int xor = 0;
		for (int i = 0; i < array.length; i++) {
			xor ^= array[i];
		}
		
		int index = 0;
		for (; index < 32; index++) {
			//1：00000000 00000000 0000000 00000001
			//xor: 假设00000000 11100000 00000001 00010000
			//1不停的左移一位，和xor中对应的位做与运算，等于1则说明找到了第一个为1的位置
			if ((xor & (1 << index)) != 0) {
				break;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & (1 << index)) != 0) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}
	
	/**
	 * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
	 *
	 * @param a
	 * @return
	 */
	public static int find1From2(int[] a) {
		int len = a.length, res = 0;
		for (int i = 0; i < len; i++) {
			res = res ^ a[i];
		}
		return res;
	}
	
	/**
	 * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
	 *
	 * @param a
	 * @return
	 */
	public static int find1From3(int[] a) {
		int[] bits = new int[32];
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < 32; j++) {
				bits[j] = bits[j] + ((a[i] >>> j) & 1);
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
			if (bits[i] % 3 != 0) {
				res = res | (1 << i);
			}
		}
		return res;
	}
	
}
