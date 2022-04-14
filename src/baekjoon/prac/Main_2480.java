package baekjoon.prac;

import java.util.Scanner;

public class Main_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a == b && b == c && c == a) {
            System.out.println(10000 + (a * 1000));
            return;
        }

        int max = Math.max(Math.max(a, b), c);
        if(a != b && b != c && c != a) {
            System.out.println(max * 100);
            return;
        }

        if(a == b) {
            System.out.println(1000 + (a * 100));
        } else if (b == c) {
            System.out.println(1000 + (b * 100));
        } else {
            System.out.println(1000 + (c * 100));
        }
    }
}
