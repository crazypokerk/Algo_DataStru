package leetcode.BinarySearch;

import java.util.*;

/**
 * @Date 2019/8/30 14:46
 */
public class _350_Intersect {
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return null;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		int l1 = nums1.length, l2 = nums2.length;
		
		// key 值 value 出现次数
		for (int i = 0; i < l1; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		
		for (int i = 0; i < l2; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		
		int[] res = new int[list.size()];
		int i = 0;
		for (int n : list) {
			res[i++] = n;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] n1 = {4, 9, 5};
		int[] n2 = {9, 4, 9, 8, 4};
		
		int[] intersect = intersect(n1, n2);
		for (int i : intersect) {
			System.out.println(i);
		}
	}
}
