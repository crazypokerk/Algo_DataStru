package leetcode.Top;

/**
 * @Date 2019/9/11 9:01
 */
public class _42_Trap {
	
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		
		int ans = 0;
		int n = height.length;
//		for (int i = 1; i < n; i++) {
//			int left_max = 0, right_max = 0;
//			for (int j = i; j >= 0; j--) {
//				left_max = Math.max(left_max, height[j]);
//			}
//			for (int j = i; j < n; j++) {
//				right_max = Math.max(right_max,height[j]);
//			}
//			ans += Math.min(left_max, right_max) - height[i];
//		}

//		int[] left_max = new int[n];
//		int[] right_max = new int[n];
//		left_max[0] = height[0];
//		right_max[n - 1] = height[n - 1];
//		for (int i = 1; i < n; i++) {
//			left_max[i] = Math.max(height[i], left_max[i - 1]);
//		}
//		for (int i = n - 2; i >= 0; i--) {
//			right_max[i] = Math.max(height[i], right_max[i + 1]);
//		}
//		for (int i = 1; i < n - 1; i++) {
//			ans += Math.min(left_max[i], right_max[i]) - height[i];
//		}
		
		int left = 0, right = n - 1;
		int l_max = height[left];
		int r_max = height[right];
		
		while (left <= right) {
			l_max = Math.max(l_max, height[left]);
			r_max = Math.max(r_max, height[right]);
			
			ans += l_max < r_max ? l_max - height[left++] : r_max - height[right--];
		}
		
		return ans;
	}
	
}
