package beakjoon._1929;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 백준 1929 - 소수 구하기 (https://www.acmicpc.net/problem/1929)
 * 알고 리즘 : 에라토스테네스의 체
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n + 1]; // 소수 판별 배열 (0: 소수, 1: 소수 X)
        arr[1] = 1; // 1은 소수가 아니다.

        // 소수 판별. n은 √n의 배수 이기 떄문에 n의 제곱근 까지만 반복 하면 된다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 현재 수가 소수 라면 현재 수의 배수를 소수가 아니 라고 표기
            if (arr[i] == 0) {
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }

        // 소수 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = m; i <= n; i++) {
            if (arr[i] == 0) {
                bw.write(String.valueOf(i));
                bw.write('\n');
            }
        }
        bw.close();
    }
}
