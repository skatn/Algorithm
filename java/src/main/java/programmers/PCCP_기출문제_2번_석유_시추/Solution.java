package programmers.PCCP_기출문제_2번_석유_시추;

import java.awt.*;
import java.util.*;

/**
 * 프로그래머스 - [PCCP 기출문제] 2번 / 석유 시추 (https://school.programmers.co.kr/learn/courses/30/lessons/250136)
 */
public class Solution {

    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Set<Integer> columns;
    private int[] columnGas;
    private Queue<Point> bfsQueue;


    public int solution(int[][] land) {
        columnGas = new int[land[0].length];

        for (int y = 0; y < land.length; y++) {
            for (int x = 0; x < land[y].length; x++) {
                // 석유가 있는 땅 위치 탐색
                if (land[y][x] == 1) {
                    // 석유를 찾았다면 bfs로 석유 크기 파악
                    columns = new HashSet<>();      // 석유가 위치한 열(column)들을 보관
                    bfsQueue = new LinkedList<>();  // 너비 우선 탐색에 사용될 큐
                    int count = bfs(land, y, x);    // 너비 우선 탐색 으로 석유 크기 파악

                    // 땅의 열 마다 위치한 석유의 크기를 누적
                    for (Integer column : columns) {
                        columnGas[column] += count;
                    }
                }
            }
        }

        // 가장 많은 석유를 가진 열을 반환
        return Arrays.stream(columnGas).max().getAsInt();
    }

    private int bfs(int[][] land, int y, int x) {
        land[y][x] = 0;
        bfsQueue.add(new Point(x, y));
        int count = 0;

        while (!bfsQueue.isEmpty()) {
            Point pos = bfsQueue.remove();
            count++;
            columns.add(pos.x);

            for (int[] dirYX : dir) {
                int yy = pos.y + dirYX[0];
                int xx = pos.x + dirYX[1];
                boolean isValidRange = yy >= 0 && yy < land.length && xx >= 0 && xx < land[0].length;
                if (isValidRange && land[yy][xx] == 1) {
                    land[yy][xx] = 0;
                    bfsQueue.add(new Point(xx, yy));
                }
            }
        }

        return count;
    }
}
