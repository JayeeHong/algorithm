package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree01_12725_dfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //노드의 갯수
        int i, j;

        //연결 정보
        ArrayList<Integer>[] list = new ArrayList[n+1];
        //초기화
        for (i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //연결
        for (i = 0; i < n - 1; i++) { //TODO: 0~5까지?
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //결과값(부모값)
        //예: parents[i] = j (i의 부모: j)
        int[] parents = new int[n + 1];

        //dfs
        dfs(list, parents, n, 1, 0);

        //결과출력
        for (j = 2; j <= n; j++) {
            System.out.println(parents[j]);
        }
    }

    private static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
        parents[start] = parent;
        for (int item : list[start]) {
            if(item != parent) dfs(list, parents, n, item, start);
        }
    }
}
