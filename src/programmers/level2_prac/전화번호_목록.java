package programmers.level2_prac;

import java.util.HashMap;

public class 전화번호_목록 {
    public static boolean solution(String[] phone_book) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : phone_book) {
            map.put(str, str);
        }

        for (String str : phone_book) {
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(solution(new String[]{"123", "456", "789"})); //true
        System.out.println(solution(new String[]{"12","123","1235","567","88"})); //false
    }
}
