package beakjoon.bronze._11050;

import java.util.Scanner;

/**
 * 백준 11050 - 이항 계수 1 (https://www.acmicpc.net/problem/11050)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 점화식 배열 초기화
        int[][] D = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        // 점화식
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[n][k]);
    }
}
