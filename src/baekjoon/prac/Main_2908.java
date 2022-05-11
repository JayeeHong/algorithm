package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());
        int num2 = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());

        System.out.println(num1 > num2 ? num1 : num2);
    }
}
