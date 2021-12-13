package programmers.level1;

public class 이천십육년 {
    public static String solution(int a, int b) {
        if(a == 1 && b == 1) return "FRI";

        String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; //idx 번호를 7로 나눴을 때 나머지 기준으로 함
        int[] lastDay = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int stdDay = 1;
        for (int i = 0; i < a-1; i++) {
            while (stdDay < lastDay[i]) {
                stdDay += 7;
            }
            stdDay -= lastDay[i];
        }

        if (stdDay > b) b += 7;

        return day[Math.abs(stdDay - b) % 7];
    }

    public static void main(String[] args) {
//        System.out.println(solution(1, 7));
//        System.out.println(solution(5, 24)); //TUE
//        System.out.println(solution(6, 24)); //FRI
//        System.out.println(solution(7, 1)); //FRI
        System.out.println(solution(8, 4)); //THU <<<
        System.out.println(solution(9, 1)); //THU <<<
        System.out.println(solution(10, 1)); //SAT
        System.out.println(solution(11, 1)); //TUE <<<
        System.out.println(solution(12, 1)); //THU <<<

    }
}
