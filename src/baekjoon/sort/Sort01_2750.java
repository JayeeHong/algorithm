package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sort01_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dataList.add(Integer.parseInt(br.readLine()));
        }

        bubbleSort(dataList);
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i));
        }

    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j+1);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        return dataList;
    }
}
