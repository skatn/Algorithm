package beakjoon._11726;

import java.util.Scanner;

/**
 * 백즌 11726 - 2×n 타일링 (https://www.acmicpc.net/problem/11726)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] D = new int[1000];
        D[0] = 1;
        D[1] = 2;

        for (int i = 2; i < n; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }

        System.out.println(D[n - 1]);
    }
}
