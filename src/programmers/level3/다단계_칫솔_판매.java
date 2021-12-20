package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        //판매원-추천인 맵
        Map<String, String> dadanMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            dadanMap.put(enroll[i], referral[i]); //key-판매원, value-추천인
        }

        //판매원-판매금액 맵
        Map<String, Integer> selMap = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            selMap.put(seller[i], amount[i] * 100);
        }

        //조직원-수익금액 맵
        Map<String, Integer> amtMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            amtMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i]; //판매원
            String referName = dadanMap.get(sellerName); //추천인

            int amtCurAmt = amtMap.get(sellerName);
            int amt = selMap.get(sellerName); //판매인의 판매금액
            amtMap.put(sellerName, amtCurAmt + (int)Math.round((amt * 0.9))); //판매인은 판매금액의 90%
            int referAmt = (int)(amt * 0.1); //추천인은 판매금액의 10%
            while (!"-".equals(referName)) {
                int referCurAmt = amtMap.get(referName); //추천인의 현재 수익금액
                amtMap.put(referName, referCurAmt + (int)Math.round(referAmt * 0.9)); //추천인 수익금액 더해줌

                referAmt = (int)Math.round(referAmt * 0.1); //다음 추천인이 있을 경우 추천인 수익에서 분배 (10%)
                referName = dadanMap.get(referName); //다음 추천인 이름
            }
        }

        for (int i=0; i< enroll.length; i++) {
            answer[i] = amtMap.get(enroll[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}))); //[360, 958, 108, 0, 450, 18, 180, 1080]
        System.out.println(Arrays.toString(solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4}))); //[0, 110, 378, 180, 270, 450, 0, 0]
    }
}
