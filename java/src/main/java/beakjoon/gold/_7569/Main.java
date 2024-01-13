package beakjoon.gold._7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7569 - 토마토 (https://www.acmicpc.net/problem/7569)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomatos = new int[H][M][N];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatos[h][m][n] = Integer.parseInt(st.nextToken());
                }
            }
        }


        int totalDays = 0;            // 토마토가 모두 익을 때 까지 걸린 날짜
        int unripeCount = 0;    // 덜 익은 토마토 개수
        int[][] dirs = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};  // 상, 우, 하, 좌, 위, 아래
        Queue<int[]> queue = new LinkedList<>(); //int[]{z, y, x, day}
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    // 익은 토마토를 기점으로 다른 토마토들이 익기 시작
                    if (tomatos[z][y][x] == 1) queue.add(new int[]{z, y, x, 0});
                    // 덜 익은 토마토 개수 증가
                    else if (tomatos[z][y][x] == 0) unripeCount++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            totalDays = now[3];

            // 상, 우, 하, 좌, 위, 아래 토마토 확인
            for (int[] dir : dirs) {
                int z = now[0] + dir[0];
                int y = now[1] + dir[1];
                int x = now[2] + dir[2];
                boolean isValidRange = z >= 0 && z < H && y >= 0 && y < M && x >= 0 && x < N;

                // 덜 익은 토마토가 있다면 익음
                if (isValidRange && tomatos[z][y][x] == 0) {
                    queue.add(new int[]{z, y, x, totalDays + 1});
                    tomatos[z][y][x] = 1;   // 토마토 익은 걸로 변경
                    unripeCount--;          // 덜 익은 토마토 개수 감소
                }
            }
        }

        // 덜 익은 토마토가 0개라면 모두 익었으므로 총 걸린 시간 출력
        // 덜 익은 토마토가 남아 있으면 -1 출력
        System.out.println(unripeCount == 0 ? totalDays : -1);
    }
}
