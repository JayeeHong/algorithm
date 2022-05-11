package baekjoon.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5622 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(Character.toString((char) (i+65)), 3);
        }
        for (int i = 3; i < 6; i++) {
            map.put(Character.toString((char) (i+65)), 4);
        }
        for (int i = 6; i < 9; i++) {
            map.put(Character.toString((char) (i+65)), 5);
        }
        for (int i = 9; i < 12; i++) {
            map.put(Character.toString((char) (i+65)), 6);
        }
        for (int i = 12; i < 15; i++) {
            map.put(Character.toString((char) (i+65)), 7);
        }
        for (int i = 15; i < 19; i++) {
            map.put(Character.toString((char) (i+65)), 8);
        }
        for (int i = 19; i < 22; i++) {
            map.put(Character.toString((char) (i+65)), 9);
        }
        for (int i = 22; i < 26; i++) {
            map.put(Character.toString((char) (i+65)), 10);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += map.get(arr[i]);
        }

        System.out.println(sum);
    }
}
