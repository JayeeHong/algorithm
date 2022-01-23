package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 신고_결과_받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> resultMap = new HashMap();//신고당한 사람
        Map<String, ArrayList<String>> reportMap = new HashMap<>();//신고한 사람
        for (String r : report) {
            String[] tempArr = r.split(" ");
            if(reportMap.containsKey(tempArr[1])) {
                if (reportMap.get(tempArr[1]).indexOf(tempArr[0]) < 0) {
                    resultMap.put(tempArr[1], resultMap.get(tempArr[1]) + 1);
                    reportMap.get(tempArr[1]).add(tempArr[0]);
                }
            } else {
                resultMap.put(tempArr[1], 1);
                reportMap.put(tempArr[1], new ArrayList(Arrays.asList(tempArr[0])));
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (resultMap.getOrDefault(id_list[i], 0) >= k) {
                for (int j = 0; j < reportMap.get(id_list[i]).size(); j++) {
                    for (int l = 0; l < id_list.length; l++) {
                        if (id_list[l].equals(reportMap.get(id_list[i]).get(j))) {
                            answer[l]++;
                            continue;
                        }
                    }
                }
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        ))); //[2,1,1,0]
        System.out.println(Arrays.toString(solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3
        ))); //[0,0]
    }
}
