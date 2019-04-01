package JianZhiOffer;

/**
 * @Date 2019/4/1 11:02
 */
public class _15_NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
