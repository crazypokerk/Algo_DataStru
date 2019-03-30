package GeekTime_Math;

/**
 * @Date 2019/3/27 8:58
 */
public class _03 {
    /**
     * @param n              待求的数
     * @param deltaThreshold 误差的阈值
     * @param maxTry         二分查找的最大次数
     * @return
     * @Description 计算大于1的正整数之平方根
     */
    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0, max = (double) n;

        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
        return -2.0;
    }

    /**
     * @param dictionary 排序后的字典
     * @param wordToFind 待查的单词
     * @return
     * @Description: 查找某个单词是否在字典里出现
     */
    public static boolean search(String[] dictionary, String wordToFind) {
        if (dictionary == null || dictionary.length == 0) {
            return false;
        }
        int left = 0, right = dictionary.length - 1;
        while (left <= right) {
            int middle = left + (right - left) >>> 1;
            if (dictionary[middle].equals(wordToFind)) {
                return true;
            } else {
                if (dictionary[middle].compareTo(wordToFind) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
