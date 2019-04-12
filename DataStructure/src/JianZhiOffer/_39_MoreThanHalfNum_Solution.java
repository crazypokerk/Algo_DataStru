package JianZhiOffer;

import java.util.Arrays;

/**
 * @Date 2019/4/5 19:31
 */
public class _39_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        if (array == null || length <= 0) {
            return 0;
        }

        int result = array[0];

        int times = 1;
        for (int i = 0; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                ++times;
            } else {
                --times;
            }
        }

        //验证出现的次数是否大于数组长度的一半
        times = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == result) {
                times++;
            }
        }

        return times > length >> 1 ? result : 0;
    }
}
