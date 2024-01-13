package beakjoon.gold._1405;

import java.util.Scanner;

/**
 * 백준 9663 - N-Queen (https://www.acmicpc.net/problem/9663)
 */
public class Main {

    private static int answer = 0;
    private static boolean[][] board;
    private static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        board = new boolean[N][N];
        search(N, 0);

        System.out.println(answer);
    }

    private static void search(int N, int count) {
        if (count == N) {
            answer++;
            return;
        }

        for (int x = 0; x < N; x++) {
            if (!board[count][x] && check(N, count, x)) {
                board[count][x] = true;
                search(N, count + 1);
                board[count][x] = false;
            }
        }
    }

    private static boolean check(int N, int y, int x) {
        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];
            while (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if(board[ny][nx]) return false;
                ny += dir[0];
                nx += dir[1];
            }
        }

        return true;
    }

}
