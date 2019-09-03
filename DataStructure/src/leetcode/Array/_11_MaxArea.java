package leetcode.Array;

/**
 * @Date 2019/9/3 15:09
 */
public class _11_MaxArea {
	
	public int maxArea(int[] height) {
		
		int start = 0, end = height.length - 1, max_area = 0;
		
		while (start < end) {
			max_area = Math.max((end - start) * Math.min(height[start], height[end]), max_area);
			if (height[start] < height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max_area;
	}
	
}
