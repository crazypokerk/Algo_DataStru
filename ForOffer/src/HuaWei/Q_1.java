package HuaWei;

import java.util.Scanner;

/**
 * @Date 2019/3/8 17:48
 */
public class Q_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            if (!(N > 0 && N <= 30000 && M > 0 && M < 5000)) {
                throw new RuntimeException("超过范围!");
            }


            int[] score = new int[N];
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
            }

            sc.nextLine();

            for (int i = 0; i < M; i++) {
                String[] line = sc.nextLine().split(" ");
                int a = Integer.parseInt(line[1]) - 1;
                int b = Integer.parseInt(line[2]) - 1;
                switch (line[0]) {
                    case "Q":
                        int max = 0;
                        for (int j = Math.min(a, b); j <= Math.max(a, b); j++) {
                            max = Math.max(max, score[j]);
                        }
                        System.out.println(max);
                        break;
                    case "U":
                        score[a] = b + 1;
                        break;
                }
            }
        }
        sc.close();
    }
}
