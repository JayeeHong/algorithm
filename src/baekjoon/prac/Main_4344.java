package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            float avg = 0;
            int[] score = new int[N];

            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                avg += score[j];
            }

            avg /= N;

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(score[j] > avg) cnt++;
            }
            sb.append(String.format("%.3f", (((float)cnt / (float)N) * 100))).append('%').append('\n');
        }

        System.out.println(sb);
    }
}
