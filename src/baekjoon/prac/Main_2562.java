package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            max = max > num ? max : num;
            cnt = max > num ? cnt : (i+1);
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
