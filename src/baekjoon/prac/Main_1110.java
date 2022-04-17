package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int first = N / 10;
        int second = N % 10;
        int temp = first + second;
        int newN = (second * 10) + (temp % 10);

        while (newN != N) {
            first = newN / 10;
            second = newN % 10;
            temp = first + second;
            newN = (second * 10) + (temp % 10);
            cnt++;
        }

        System.out.println(cnt);
    }
}
