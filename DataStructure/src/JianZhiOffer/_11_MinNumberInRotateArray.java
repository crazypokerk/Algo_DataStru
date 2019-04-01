package JianZhiOffer;

/**
 * @Date 2019/4/1 10:07
 */
public class _11_MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) >> 1;
        if (array[right] == array[left] || array[mid] == array[right] || array[mid] == array[left]) {
            return findMin(array);
        }
        if (array[mid] > array[left] && array[mid] < array[right]) {
            return array[0];
        }
        while (true) {
            mid = left + (right - left) >> 1;
            if (array[mid] > array[left]) {
                left = mid;
            } else if (array[mid] < array[right]) {
                right = mid;
            }
            if ((left + 1) == right) break;
        }
        return array[right];
    }

    public static int findMin(int[] array) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= array.length - 1; i++) {
            result = Math.min(result, array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 1};
        System.out.println(minNumberInRotateArray(a));

    }
}
