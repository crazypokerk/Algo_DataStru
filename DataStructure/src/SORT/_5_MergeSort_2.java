package SORT;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date 2019/6/17 14:57
 */
public class _5_MergeSort_2 {
  public int[] sort(int[] sourceArray) {
    int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

    if (arr.length < 2) {
      return arr;
    }
    int middle = (int) Math.floor(arr.length);

    int[] left = Arrays.copyOfRange(arr, 0, middle);
    int[] right = Arrays.copyOfRange(arr, middle + 1, arr.length);

    return merge(sort(left), sort(right));
  }

  public int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0;

    //两边的元素都大于1的情况
    while (left.length > 0 && right.length > 0) {
      if (left[0] <= right[0]) {
        result[i++] = left[0];
        left = Arrays.copyOfRange(left, 1, left.length);
      } else {
        result[i++] = right[0];
        right = Arrays.copyOfRange(right, 1, right.length);
      }
    }

    //分出来的右边没有元素了
    while (left.length > 0) {
      result[i++] = left[0];
      left = Arrays.copyOfRange(left, 1, left.length);
    }

    //分出来的左边没有元素了
    while (right.length > 0) {
      result[i++] = right[0];
      right = Arrays.copyOfRange(right, 1, right.length);
    }

    return result;
  }
}
