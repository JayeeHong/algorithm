package baekjoon.prac;

import java.util.Scanner;

public class Main_2588 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int mok = b / 10;
        int rest = b % 10;

        System.out.println(a * rest);
        while (mok > 0) {
            rest = mok % 10;
            mok /= 10;
            System.out.println(a * rest);
        }
        System.out.println(a * b);
    }
}
