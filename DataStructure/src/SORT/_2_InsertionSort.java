package SORT;

/**
 * 插入排序
 * 原地排序算法，空间复杂度为o(1)
 * 稳定的排序算法
 * 最好情况时间复杂度为o(n)
 * 最坏情况时间复杂度为o(n2)
 * 平均情况下的时间复杂度是：o(n2)
 */
public class _2_InsertionSort {
    public static int[] insertionSort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }

        //第一轮，从未排序区域中随机拿出一个数字，既然是随机，那么我们就获取第一个
        //然后插入到已排序区域中，此时已排序区域为空，那么就不做比较，默认自身有序
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] n = {9, 6, 7, 5, 4};
        int l = 5;
        insertionSort(n, l);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
}
