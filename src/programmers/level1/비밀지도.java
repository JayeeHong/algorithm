package programmers.level1;

import java.util.Arrays;

public class 비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String arr1Val = String.format("%1$" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String arr2Val = String.format("%1$" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            String[] arr1ValSplit = arr1Val.split("");
            String[] arr2ValSplit = arr2Val.split("");

            String str = "";
            for (int j = 0; j < arr1ValSplit.length; j++) {
                if (arr1ValSplit[j].equals("1") || arr2ValSplit[j].equals("1")) {
                    str += "#";
                } else {
                    str += " ";
                }
            }

            answer[i] = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))); //["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}))); //["######", "### #", "## ##", " #### ", " #####", "### # "]
    }
}
