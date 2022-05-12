package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() == 1) {
                cnt++;
            } else {
                List<Character> stringList = new ArrayList<>();
                boolean flag = true;
                for (int j = 0; j < str.length(); j++) {
                    if (stringList.contains(str.charAt(j))) {
                        if(str.charAt(j) != str.charAt(j-1)) {
                            flag = false;
                            break;
                        }
                    } else {
                        stringList.add(str.charAt(j));
                    }
                }

                if(flag) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
