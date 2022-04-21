package baekjoon.prac;

public class Main_4673 {
    public static void main(String[] args) {
        boolean[] chk = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int n = d(i);
            if(n < 10001) chk[n] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if(!chk[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static int d(int num) {
        int sum = num;

        while (num != 0) {
            sum = sum + (num % 10);
            num /= 10;
        }

        return sum;
    }
}
