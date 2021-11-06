package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {
    public static boolean solution(String[] phone_book) {

        Map<String, String> phoneMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phoneMap.put(phone_book[i], phone_book[i]);
        }

        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++) {
                if (phoneMap.containsKey(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;

        //효율성 실패
//        for (int i = 0; i < phone_book.length; i++) {
//            String mapVal = phoneMap.get(i);
//            for (int j = 0; j < phone_book.length; j++) {
//                String arrVal = phone_book[j];
//                if (!mapVal.equals(arrVal) && mapVal.startsWith(arrVal)) {
//                    return false;
//                }
//            }
//
//        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(solution(new String[]{"123","456","789"})); //true
        System.out.println(solution(new String[]{"12","123","1235","567","88"})); //false
    }
}
