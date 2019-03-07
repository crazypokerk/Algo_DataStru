package CodingInterview._1_4Pet;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * @Date 2019/3/7 10:31
 */
public class _1_7GetMaxWindow {

    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }

            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
