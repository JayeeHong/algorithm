package programmers.level1;

public class 다트_게임 {
    public static int solution(String dartResult) {
        int answer = 0;

        String temp = "";
        int arr[] = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) == '*') {
                arr[idx-1] *= 2;
                if(idx > 1) arr[idx-2] *= 2;
            } else if (dartResult.charAt(i) == '#') {
                arr[idx-1] *= -1;
            } else if (dartResult.charAt(i) == 'S') {
                arr[idx] = (int) Math.pow(Integer.parseInt(temp), 1);
                idx++;
                temp = "";
            } else if (dartResult.charAt(i) == 'D') {
                arr[idx] = (int) Math.pow(Integer.parseInt(temp), 2);
                idx++;
                temp = "";
            } else if (dartResult.charAt(i) == 'T') {
                arr[idx] = (int) Math.pow(Integer.parseInt(temp), 3);
                idx++;
                temp = "";
            } else {
                temp += String.valueOf(dartResult.charAt(i));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T")); //37
        System.out.println(solution("1D2S#10S")); //9
        System.out.println(solution("1D2S0T")); //3
        System.out.println(solution("1S*2T*3S")); //23
        System.out.println(solution("1D#2S*3S")); //5
        System.out.println(solution("1T2D3D#")); //-4
        System.out.println(solution("1D2S3T*")); //59
    }
}
