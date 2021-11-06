package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 문자열_압축 {
    public static int solution(String s) {
        int answer = 0;

        Map<Integer, String> splitMap = new HashMap<>();

        if (s.length() == 1) {
            return 1;
        }

        for (int n = 0; n < s.length() / 2; n++) {
            String curStr = s.substring(0, n+1); //현재 글자. 0~n+1 만큼 자른 문자로 초기화
            String splitStr = "";
            int cnt = 1; //반복되는 수 구할 변수
            for (int i = n+1; i < s.length(); i+=(n+1)) {
                int splitCnt = i+n+1;
                if(splitCnt > s.length()) splitCnt = s.length();

                String nextStr = s.substring(i, splitCnt); //다음 글자
                String loopStr = curStr;
                //두 글자 비교했을 때 같다면 반복카운트 증가
                if (curStr.equals(nextStr)) {
                    cnt++;

                //두 글자 비교했을 때 다르다면 반복카운트 값에 따라 분기처리
                } else {
                    //반복카운트가 1이면 splitStr에 숫자 없이 값 넣어줌
                    if (cnt == 1) {
                        splitStr += loopStr;
                        curStr = nextStr;
                    //반복카운트가 2 이상이면 splitStr에 숫자+문자열만큼 넣어줌
                    } else {
                        splitStr += cnt + loopStr;
                        curStr = nextStr;
                        cnt = 1;
                    }
                }

                if (i+n+1 > s.length()-1) {
                    if (cnt == 1) {
                        splitStr += s.substring(i);
                    } else {
                        splitStr += cnt + curStr;
                    }
                }
            }

            splitMap.put(n, splitStr);
        }

        //splitMap 안에서 가장 짧은 문자열 계산
        int min = splitMap.get(1).length();
        for (Integer key : splitMap.keySet()) {
            if (min > splitMap.get(key).length()) {
                min = splitMap.get(key).length();
            }
        }

        answer = min;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); //7
        System.out.println(solution("ababcdcdababcdcd")); //9
        System.out.println(solution("abcabcdede")); //8
        System.out.println(solution("abcabcabcabcdededededede")); //14
        System.out.println(solution("xababcdcdababcdcd")); //17
        System.out.println(solution("a")); //1
    }
}
