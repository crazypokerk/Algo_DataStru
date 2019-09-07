package leetcode.Top;

/**
 * @Date 2019/9/7 13:43
 */
public class _88_MergeSortArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int pre = m-- + n-- - 1;
		while (m >= 0 && n >= 0) {
			nums1[pre--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		//当nums2还有元素时，就是直接将n上的元素替换到pre
		while (n >= 0) {
			nums1[pre--] = nums2[n--];
		}
	}
	
}
