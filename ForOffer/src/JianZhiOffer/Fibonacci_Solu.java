package JianZhiOffer;

public class Fibonacci_Solu {
    public int Fibonacci(int n) {
        int result[] = {0, 1};
        if (n < 2) {
            return result[n];
        }

        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }
}
