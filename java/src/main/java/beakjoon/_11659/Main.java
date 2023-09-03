package beakjoon._11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //수의 개수
        int m = sc.nextInt();   //합을 구해야 하는 횟수
        int[] hap = new int[n];

        for (int i = 0; i < n; i++) {
            hap[i] = sc.nextInt() + (i == 0 ? 0 : hap[i-1]);
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;

            System.out.println(hap[end] - (start == 0 ? 0 : hap[start-1]));
        }

    }
}
