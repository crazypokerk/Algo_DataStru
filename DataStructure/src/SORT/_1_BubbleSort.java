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
    public static int[] bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }

        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] n = {3, 5, 4, 1, 2, 6};
        int len = 6;
        bubbleSort(n, len);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
}
