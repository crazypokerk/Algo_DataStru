package CodingInterview.chap5;

/**
 * 替换字符串中连续出现的指定字符串
 *
 * @Date 2019/3/21 15:18
 */
public class _5_P251Replace {
    public String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }

        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();

        int match = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == chaf[match++]) {
                if (match == chaf.length) {

                }
            } else {
                if (chas[i] == chaf[0]) {
                    i--;
                }
                match = 0;
            }
        }
        return "S";
    }

}
