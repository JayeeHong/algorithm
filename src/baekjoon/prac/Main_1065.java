package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        if(N < 100) {
            cnt += N;
        } else if(N <= 1000) {
            cnt += 99;
            for (int i = 100; i <= N; i++) {
                if(isHansu(i)) cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isHansu(int num) {
        boolean flag;

        int first = (num / 100);
        int second = (num - (first * 100)) / 10;
        int third = (num - (first * 100)) % 10;

        if((first - second) == (second - third)) flag = true;
        else if((second - first) == (third - second)) flag = true;
        else flag = false;

        return flag;
    }
}
