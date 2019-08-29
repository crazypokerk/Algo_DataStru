package leetcode.BinarySearch;

/**
 * @Date 2019/8/29 16:36
 */
public class _74_SearchMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) return false;
		
		int left = 0, right = (matrix.length * matrix[0].length) - 1;
		int midIndex, midElement;
		
		while (left <= right) {
			midIndex = left + ((right - left) >> 1);
			midElement = matrix[midIndex / matrix[0].length][midIndex % matrix[0].length];
			
			if (midElement == target) {
				return true;
			} else if (midElement > target) {
				right = midIndex - 1;
			} else {
				left = midIndex + 1;
			}
		}
		return false;
	}
	
}
