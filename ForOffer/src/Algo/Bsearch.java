package Algo;

public class Bsearch {
    //最简单情况的二分查找
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (high + low) >> 1;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //递归实现二分查找
    public int bsearch_(int[] a, int n, int value) {

        return bsearchInternally(a, 0, n - 1, value);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = (high + low) >> 1;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        }else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    //查找第一个值等于给定值的元素
    //数组有序但有重复元素{1，3，4，5，6，8，8，8，11，18}
    public int bsearch1(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + (high - low) >> 2);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            }else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public int bsearch2(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + (low - high) >> 2);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                high = mid + 1;
            }else {
                if ((mid == n - 1) || a[mid + 1] != value) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    //{3，4，6，7，10}
    public int bsearch3(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    //{3，5，6，8，9，10}
    public int bsearch4(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            }else {
                if ((mid == n - 1) || (a[mid + 1] > value)) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private class s{
        private int a;

        //private static int b;
        public void a() {

        }
    }
}
