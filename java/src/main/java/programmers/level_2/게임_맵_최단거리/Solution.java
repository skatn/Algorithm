package programmers.level_2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 게임 맵 최단거리 (https://school.programmers.co.kr/learn/courses/30/lessons/1844)
 */
public class Solution {

    public int solution(int[][] maps) {
        BFS(maps);

        // BFS를 수행 하면 이동 경로에 이동 거리가 음수로 표시 된다.
        // 그래서 양수로 바꿔 주기 위해 (-)를 곱해 양수로 바꿔 준다.
        // 만약 목적지에 도달 하지 못했다면 1로 남아 있기 때문에 음수를 곱하면 (-1)이 된다.
        return -maps[maps.length - 1][maps[0].length - 1];
    }

    private void BFS(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌 {y, x}

        // 현재 위치를 큐에 넣고 거리를 -1로 설정
        queue.add(new int[]{0, 0});
        maps[0][0] = -1;

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] now = queue.remove(); // 현재 위치
            // 만약 목적지에 도달 했다면 BFS 종료
            if(now[0] == maps.length && now[1] == maps[0].length) break;

            // 현재 위치 에서 상, 우, 하, 좌 방향 탐색
            for (int[] dir : dirs) {
                int y = now[0] + dir[0];
                int x = now[1] + dir[1];
                boolean isValidRange = y >= 0 && y < maps.length && x >= 0 && x < maps[0].length;

                // 만약 이동할 수 있는 곳이 있으면 방문
                if (isValidRange && maps[y][x] == 1) {
                    maps[y][x] = maps[now[0]][now[1]] - 1; // 현재 위치의 이동 거리에 1을 빼서 이동 거리 누적
                    queue.add(new int[]{y, x});
                }
            }
        }
    }
}
