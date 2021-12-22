package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 문자열_내_마음대로_정렬하기 {
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Arrays.sort(strings);
        ArrayList<SortStr> strArrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            strArrayList.add(new SortStr(i, strings[i].charAt(n)));
        }

        Collections.sort(strArrayList);

        for (int i = 0; i < strArrayList.size(); i++) {
            answer[i] = strings[strArrayList.get(i).getIdx()];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1))); //["car", "bed", "sun"]
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2))); //["abcd", "abce", "cdx"]
    }
}

class SortStr implements Comparable<SortStr> {
    private int idx;
    private char str;

    public SortStr(int idx, char str) {
        this.idx = idx;
        this.str = str;
    }

    public int getIdx() {
        return idx;
    }

    public char getStr() {
        return str;
    }

    @Override
    public int compareTo(SortStr s) {
        if((int)s.str < (int)str) {
            return 1;
        } else if((int)s.str > (int)str) {
            return -1;
        }

        return 0;
    }
}