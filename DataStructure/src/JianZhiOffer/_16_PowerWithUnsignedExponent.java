package JianZhiOffer;

/**
 * @Date 2019/3/26 16:51
 */
public class _16_PowerWithUnsignedExponent {
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);

        result *= result;

        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(powerWithUnsignedExponent(2, 4));
    }
}
