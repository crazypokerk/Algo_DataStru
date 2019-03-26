package Algo;

import java.util.ArrayList;

/**
 * @Date 2019/3/2 10:19
 */
public class sdadas1 {
    public static void main(String[] args) {
        int n = 100;
        FizzBuzz(n);
    }

    public static void FizzBuzz(int num) {
        ArrayList al = new ArrayList(num);
        String FizzBuzz = "FizzBuzz";
        String Fizz = "Fizz";
        String Buzz = "Buzz";
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                al.add(FizzBuzz);
            } else if (i % 5 == 0 && i % 3 != 0) {
                al.add(Buzz);
            } else if (i % 5 != 0 && i % 3 == 0) {
                al.add(Fizz);
            } else {
                al.add(i);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
