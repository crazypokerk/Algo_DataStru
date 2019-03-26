package JianZhiOffer;

/**
 * 斐波那契数列
 *
 * @Date 2019/3/22 16:05
 */
public class _10_Fibonacci {
    public long fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long fibMinusOne = 1;
        long fibMinusTwo = 0;
        long fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibMinusOne + fibMinusTwo;

            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }

        return fibN;
    }
}
