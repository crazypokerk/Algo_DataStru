package JianZhiOffer;

/**
 * @Date 2019/4/4 14:07
 */
public class _42_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (array == null || len <= 0) {
            return 0;
        }

        int curSum = 0;
        //0x80000000是32位数最小值 -2的32次方
        int curGreatSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            if (curSum <= 0) {
                //记录当前最大值
                curSum = array[i];
            }else {
                //当array[i]为正时，加上之前的最大值
                curSum += array[i];
            }
            if (curSum > curGreatSum) {
                curGreatSum = curSum;
            }
        }
        return curGreatSum;
    }
}
