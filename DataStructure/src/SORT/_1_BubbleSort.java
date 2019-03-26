package SORT;

/**
 * 冒泡排序
 * 原地排序算法，空间复杂度为o(1)
 * 稳定的排序算法
 * 最好情况时间复杂度为o(n)
 * 最坏情况时间复杂度为o(n2)
 * 平均情况下的时间复杂度是：o(n2)
 */
public class _1_BubbleSort {
    public static void bubbleSort(int[] nums, int len) {
        if (len <= 1) {
            return;
        }

        for (int i = 0; i < len; ++i) {
            boolean flag = false;
            for (int j = 1; j < len - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {

                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] n = {3, 5, 4, 1, 2, 6};
        int len = 6;
        bubbleSort(n, len);
    }
}
