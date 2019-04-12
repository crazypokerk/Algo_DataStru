package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @Date 2019/4/6 18:25
 */
public class _56_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        return map.get(k) == null ? 0 : map.get(k);
    }
}
