package leetcode.Top;

/**
 * @Date 2019/9/7 9:52
 */
public class _190_ReverseBits {
	
	public int reverseBits(int n) {
		int res = 0;
		
		for (int i = 0; i < 32; i++) {
			int tmp = n >> i;
			
			tmp = tmp & i;
			
			tmp = tmp << (31 - i);
			
			res |= tmp;
		}
		
		return res;
	}
	
}
