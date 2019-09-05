package leetcode.Top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2019/9/5 15:51
 */
public class _350_Intersect {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.get(nums1[i]) == null ? 1 : map.get(nums1[i]) + 1);
		}
		
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
}
