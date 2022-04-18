package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        float[] score = new float[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        float M = score[N - 1];
        float avg = 0;
        for (int i = 0; i < N; i++) {
            avg += (score[i]/M*100);
        }
        avg /= N;

        System.out.println(avg);
    }
}
