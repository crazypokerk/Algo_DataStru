package JianZhiOffer;

/**
 * 数组中重复的数字：
 *      从头到尾依次扫描数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。
 *      如果是，则接着扫描下一个数字；如果不是，则再拿它和第m个数字进行比较。如果它和第m个数字相等，就找到了
 *      一个重复的数字（该数字在下标为i和m的位置都出现了）；如果它和第m个数字不相等，就把第i个数字和第m个数字
 *      交换，把m放到属于它的位置。接下来重复这个比较、交换的过程，直到我们发现一个重复的数字。
 */
public class _3_FindDuplicates {
    public static boolean findDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int m = nums[i];
                if (nums[m] == nums[i]) {
                    return false;
                } else {
                    int tmp;
                    tmp = nums[m];
                    nums[m] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return false;
    }

}
