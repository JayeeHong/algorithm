package programmers.level2_prac;

public class 멀쩡한_사각형 {
    public static long solution(int w, int h) {
        int gcd = getGCD(w, h);

        return (long)w * h - (w + h - gcd);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12)); //80
    }
}
