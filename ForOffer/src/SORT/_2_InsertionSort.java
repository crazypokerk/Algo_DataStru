package SORT;

/**
 * 插入排序
 *      原地排序算法，空间复杂度为o(1)
 *      稳定的排序算法
 *      最好情况时间复杂度为o(n)
 *      最坏情况时间复杂度为o(n2)
 *      平均情况下的时间复杂度是：o(n2)
 */
public class _2_InsertionSort {
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                }else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] n = {4, 5, 6, 1, 2, 3};
        int l = 6;
        insertionSort(n, l);
    }
}
