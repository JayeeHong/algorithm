package baekjoon.prac;

import java.util.Scanner;

public class Main_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int sum = (A*60) + B + C;

        int h = sum / 60;
        int m = sum % 60;

        while(h >= 24) {
            h -= 24;
        }

        System.out.println(h + " " + m);
    }
}
