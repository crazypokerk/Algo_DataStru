package Algo;

import java.util.Arrays;

/**
 * @Date 2019/3/2 10:51
 */
public class sadfasd2 {
    public static void main(String[] args) {
        String s = "funz times*3";
        System.out.println(LetterChanges(s));
    }

    public static String LetterChanges(String str) {
        String result = "";
        char[] yuanyin = {'a', 'e', 'i', 'o', 'u'};
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'z' || c[i] == 'Z') {
                c[i] = (char) (c[i] - 25);
            } else if (c[i] <= 'z' && c[i] >= 'a' || c[i] <= 'Z' && c[i] >= 'A') {
                c[i] = (char) (c[i] + 1);
            }
            for (int j = 0; j < yuanyin.length; j++) {
                if (c[i] == yuanyin[j]) {
                    c[i] = (char) (c[i] - 32);
                }
            }
        }

        return String.valueOf(c);
    }

    public static int maximalSquare(char[][] strArr){
        if(strArr == null || strArr.length==0){
            return 0;
        }
        int m = strArr.length;
        int n = strArr[0].length;
        int max = Integer.MIN_VALUE;
        int[][] d = new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(i==0||j==0){
                    d[i][j] = (strArr[i][j] == '1' ? 1 : 0);
                }else{
                    if(strArr[i][j] == '0'){
                        d[i][j]=0;
                    }else{
                        d[i][j] = Math.min(d[i-1][j],Math.min(d[i][j-1],d[i-1][j-1]))+1;
                    }
                }
                max = (max < d[i][j]) ? d[i][j] : max;
            }
        }
        return max*max;
    }
}
