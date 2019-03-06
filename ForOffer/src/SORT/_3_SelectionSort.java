package SORT;

/**
 * 选择排序
 *      原地排序算法，空间复杂度为o(1)
 *      不稳定的排序算法
 *      最好情况时间复杂度为o(n2)
 *      最坏情况时间复杂度为o(n2)
 *      平均情况下的时间复杂度是：o(n2)
 */
public class _3_SelectionSort {
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            //查找最小值
            int minIndex = i;
            for (int j = 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}
