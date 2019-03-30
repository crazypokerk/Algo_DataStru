package JianZhiOffer;

import java.util.ArrayList;

/**
 * @Date 2019/3/30 12:42
 */
public class _49_GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        int index2 = 0, index3 = 0, index5 = 0;
        while (resultList.size() < index) {
            int m2 = resultList.get(index2) * 2;
            int m3 = resultList.get(index3) * 3;
            int m5 = resultList.get(index5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            resultList.add(min);
            if (min == m2) {
                index2++;
            }
            if (min == m3) {
                index3++;
            }
            if (min == m5) {
                index5++;
            }
        }
        return resultList.get(resultList.size() - 1);

    }
}
