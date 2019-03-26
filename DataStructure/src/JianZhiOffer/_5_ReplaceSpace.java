package JianZhiOffer;

public class _5_ReplaceSpace {
    public static char[] replaceSpace(String str) {
        if (str.equals(" ")) {
            return null;
        }
        char[] c = str.toCharArray();

        int i = 0;
        int lengthSpace = 0;

        while (i < c.length) {
            if (c[i] == ' ') {
                lengthSpace++;
            }
            i++;
        }

        int newLength = c.length + lengthSpace * 2;

        char[] newC = new char[newLength];

        int a = newLength - 1;
        i = c.length - 1;

        while (i >= 0) {
            if (c[i] != ' ') {
                newC[a--] = c[i--];
            } else {
                newC[a--] = '0';
                newC[a--] = '2';
                newC[a--] = '%';
                i--;
            }
        }

        return newC;
    }

    public static void main(String[] args) {
        String c = "we are happy";
        System.out.println(replaceSpace(c));
    }
}
