package programmers.level2;

import java.util.*;

public class 영어_끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Map<String, Integer> map = new HashMap<>();

        int failNum = -1;
        String prevWord = "";
        for (int i = 0; i < words.length; i++) {
            String nowWord = words[i];
            if (i > 0) {
                if (prevWord.charAt(prevWord.length() - 1) != nowWord.charAt(0) ||
                        map.containsKey(nowWord)) {
                    failNum = i;
                    break;
                }

            }

            map.put(words[i], i);
            prevWord = nowWord;
        }

        if (failNum != -1) {
            answer[0] = failNum % n + 1;
            answer[1] = failNum / n + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); //3,3
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); //0,0
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); //1,3
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "e", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
    }
}
