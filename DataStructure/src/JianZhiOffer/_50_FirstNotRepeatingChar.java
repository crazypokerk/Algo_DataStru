package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/3/30 11:00
 */
public class _50_FirstNotRepeatingChar {
    public static char FirstNotRepeatingChar(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], 1);
            } else {
                map.put(c[i], map.get(c[i]) + 1);
            }
        }

        char tmp = 0;
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1) {
                tmp = c[i];
                break;
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(FirstNotRepeatingChar(s));
    }
}
