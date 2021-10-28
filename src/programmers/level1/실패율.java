package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 실패율 {

    static class FailRate {
        int idx;
        double rate;

        public FailRate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "FailRate{" +
                    "idx=" + idx +
                    ", rate=" + rate +
                    '}';
        }
    }

    public static int[] solution(int N, int[] stages) {
        //solution(5, new int[]{2,1,2,6,2,4,3,3})
        int[] answer = new int[N];

        int[] dodalUser = new int[N]; //도달한 유저 수
        for(int i=0; i<stages.length; i++) {
            if(stages[i] > N) {
                continue;
            } else {
                dodalUser[stages[i] - 1]++;
            }
        }

        System.out.println(Arrays.toString(dodalUser));

        int[] perStageUser = new int[N]; //스테이지별 실패율 계산할 유저 수
        perStageUser[0] = stages.length;
        for(int i=1; i<N; i++) {
            perStageUser[i] = perStageUser[i-1] - dodalUser[i-1];
        }

        System.out.println(Arrays.toString(perStageUser));

        Double[] calArr = new Double[N];
        for (int i = 0; i < N; i++) {
            calArr[i] = perStageUser[i] != 0 ? ((double) dodalUser[i] / perStageUser[i]) * 100 : 0.0;
        }

        System.out.println(Arrays.toString(calArr));

        ArrayList<FailRate> failRate = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            failRate.add(new FailRate(i + 1, calArr[i]));
        }

        Collections.sort(failRate, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        System.out.println(failRate.toString());

        for (int i = 0; i < N; i++) {
            answer[i] = failRate.get(i).idx;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 2, 1, 3}));
    }
}
