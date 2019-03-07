package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和：
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @Date 2019/3/6 11:33
 */
public class _171_threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        /*if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }*/
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        //将数组排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (right + 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] n = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(n));
    }
}
