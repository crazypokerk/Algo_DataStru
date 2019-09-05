package leetcode.Top;

/**
 * @Date 2019/9/5 11:23
 */
public class _204_CountPrimes {
	
	public int countPrimes(int n) {
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
		}
		
		for (int i = 2; i < n; i++) {
			if (arr[i] == 1) {
				for (int j = 2; i * j < n; j++) {
					arr[i * j] = 0;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (arr[i] == 1) {
				count++;
			}
		}
		return count;
	}
	
}
