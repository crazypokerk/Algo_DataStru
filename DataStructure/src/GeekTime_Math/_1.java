package GeekTime_Math;

import java.math.BigInteger;

/**
 * @Date 2019/3/26 9:50
 */
public class _1 {
    /*
        十进制转换成二进制
     */

    public static String decimalToBinary(int decimalSource) {
        //转换成BigInteger
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        return bi.toString(2);//参数指定的是转换成二进制
    }

    /*
        二进制转换成十进制
     */

    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);//转换为BigInteger类型
        return Integer.parseInt(bi.toString());//默认转换成十进制
    }

    public static void main(String[] args) {
        int a = 53;
        String b = "1101001";
        System.out.println(String.format("数字 %d 的二进制是 %s", a, decimalToBinary(a)));
        System.out.println(String.format("数字 %s 的十进制是 %d", b, binaryToDecimal(b)));
    }
}
