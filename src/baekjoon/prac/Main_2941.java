package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {
    public static void main(String[] args) throws IOException {
        String[] croatia = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (String c : croatia) {
            if (str.contains(c)) {
                str = str.replace(c, "!");
            }
        }

        System.out.println(str.length());
    }
}
