package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tot = 1;
        for (int i = 0; i < 3; i++) {
            tot *= Integer.parseInt(br.readLine());
        }

        int[] arr = new int[10];
        String[] totArr = Integer.toString(tot).split("");
        for (int i = 0; i < totArr.length; i++) {
            arr[Integer.parseInt(totArr[i])]++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
