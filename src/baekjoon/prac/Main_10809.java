package baekjoon.prac;

import java.io.*;
import java.util.Arrays;

public class Main_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < str.length(); i++) {
            int pos = arr[(int)str.toCharArray()[i] - 97];
            if(pos == -1) arr[(int)str.toCharArray()[i] - 97] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
