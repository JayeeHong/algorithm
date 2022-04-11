package dev_matching_상반기;

import java.util.*;

public class Task1 {
    static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int[][] solution(int[][] dist) {
        int[][] answer = {};

        HashMap<Pos, Integer> distMap = new HashMap<>();
        int min = dist[0][1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = i+1; j < dist[i].length; j++) {
                distMap.put(new Pos(i, j), dist[i][j]);
                min = min < dist[i][j] ? min : dist[i][j];
            }
        }

        LinkedList<Pos> linkedlist = new LinkedList<>();
        Set<Map.Entry<Pos, Integer>> entrySet = distMap.entrySet();
        for (Map.Entry<Pos, Integer> entry : entrySet) {
            if (entry.getValue() == min) {
                linkedlist.add(new Pos(entry.getKey().getX(), entry.getKey().getY()));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,5,2,4,1}, {5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}}));
    }
}
