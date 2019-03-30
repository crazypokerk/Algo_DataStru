package GeekTime_Math;

/**
 * @Date 2019/3/27 10:12
 */
public class _5 {
    public void a(int n) {
        if (n == 1) {
            return;
        }

        int i = 2;
        for (; i <= n; i++) {
            if (n % i == 0) {
                if (i == n) {
                    System.out.println(i);
                } else {
                    a(n / i);
                    break;
                }
            }
        }
    }
}
