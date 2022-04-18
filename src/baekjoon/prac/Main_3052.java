package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        }

        Arrays.sort(arr);

        int cnt = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1]) cnt++;
        }

        System.out.println(cnt);
    }
}
