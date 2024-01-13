package beakjoon.silver._2178;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178 - 미로 탐색 (https://www.acmicpc.net/problem/2178)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // map의 y size
        int m = Integer.parseInt(st.nextToken()); // map의 x size

        // map 저장
        int[][] map = new int[n][m];
        for (int y = 0; y < n; y++) {
            String s = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = s.charAt(x) - '0';
            }
        }

        BFS(map, new Point(m, n));
        System.out.println(map[n-1][m-1]);
    }

    public static void BFS(int[][] map, Point size) {
        int[][] visit = new int[size.y][size.x];
        Queue<Point> queue = new LinkedList<>(); // 방문 했던 위치 좌표를 저장
        // [상, 우, 하, 좌] 방향. (y, x)
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //시작 위치 방문
        visit[0][0] = 1;
        queue.add(new Point(0, 0));

        // 방문한 곳이 있으면 해당 위치의 [상, 우, 하, 좌] 방문
        while (!queue.isEmpty()) {
            // 현재 위치의 좌표
            Point point = queue.remove();

            // 현재 위치로 부터 [상, 우, 하, 좌] 방문
            for (int i = 0; i < dir.length; i++) {
                int y = point.y + dir[i][0];
                int x = point.x + dir[i][1];
                boolean isValidRange = y >= 0 && y < size.y && x >= 0 && x < size.x;

                // 방문 할 수 있지만 아직 방문 하지 않은 곳이 있으면 방문
                if (isValidRange && map[y][x] > 0 && visit[y][x] == 0) {
                    visit[y][x] = 1;
                    map[y][x] = map[point.y][point.x] + 1; // 해당 위치의 거리값 = 현재 위치의 거리값 + 1
                    queue.add(new Point(x, y));
                }
            }
        }
    }

}
