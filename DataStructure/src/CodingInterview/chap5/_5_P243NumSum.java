package CodingInterview.chap5;

/**
 * 字符串中数字子串的求和
 *
 * @Date 2019/3/16 16:16
 */
public class _5_P243NumSum {
    public int numSum(String str) {
        if (str == null) {
            return 0;
        }

        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;

        //'0' 48  '9'  57 'a' 97 'A' 65
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }
}
