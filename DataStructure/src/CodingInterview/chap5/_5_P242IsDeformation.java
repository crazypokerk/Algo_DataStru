package CodingInterview.chap5;

/**
 * 判断两个字符串是否互为变形词
 *
 * @Date 2019/3/16 16:07
 */
public class _5_P242IsDeformation {
    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] chas1 = new char[str1.length()];
        char[] chas2 = new char[str2.length()];

        int[] map = new int[256];

        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }

        for (int i = 0; i < chas2.length; i++) {
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
