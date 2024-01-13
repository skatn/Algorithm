package beakjoon.silver._11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11047 - 동전 0 (https://www.acmicpc.net/problem/11047)
 * 풀이 : 그리디 알고리즘
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 가치가 큰 동전 -> 가치가 작은 동전 순으로 사용
        for (int i = n - 1; i >= 0; i--) {
            // 목표 금액의 가치가 현재 동전의 가치 보다 크거나 같을 경우 동전 사용
            if(k >= coins[i]) {
                count += k / coins[i];  // k의 가치에 사용할 수 있는 현재 동전 개수 계산
                k %= coins[i];          // 목표 금액 변경
            }
        }

        System.out.println(count);
    }
}
