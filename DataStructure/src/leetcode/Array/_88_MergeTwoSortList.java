package leetcode.Array;

/**
 * @Date 2019/8/26 8:38
 */
public class _88_MergeTwoSortList {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int pre = m-- + n-- - 1;
		
		while (m >= 0 && n >= 0) {
			nums1[pre--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		
		while (n >= 0) {
			nums1[pre--] = nums2[n--];
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 7, 0, 0};
		int[] b = {2, 5};
		
		merge(a, 4, b, 2);
		
		for (int i : a) {
			System.out.println(i);
		}
	}
	
}
