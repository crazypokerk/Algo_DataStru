package SORT;

import java.util.ArrayList;

public class _6_QuickSort {
    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

//主要思想是用栈来保存子数组的左右边界，代码中用数组模拟栈
    void quicksort_unrecursion(int[] arr)//快速排序非递归
    {
        int[] mystack = new int[2000];//假设递归不超过1000层
        //栈中保存下次需要排序的子数组的开始位置和结束位置
        int top = -1;
        mystack[++top] = 0;
        mystack[++top] = arr.length - 1;
        while(top > 0)//栈非空
        {
            int high = mystack[top--], low = mystack[top--];
            int middle = partition(arr, low, high);
            if(middle+1 < high)//右边子数组入栈
            {
                mystack[++top] = middle+1;
                mystack[++top] = high;
            }
            if(low < middle-1)//左边子数组入栈
            {
                mystack[++top] = low;
                mystack[++top] = middle-1;
            }
        }
    }

}
