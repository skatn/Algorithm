package beakjoon._1940;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1940 - 주몽 (https://www.acmicpc.net/problem/1940)
 * 알고리즘 : 투 포인터
 */
public class Main {
    public static void main(String[] args) {
        solution2();
    }

    private static void solution1() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == m) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    //투 포인터
    public static void solution2() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //투 포인터를 사용하기 위해선 정렬이 필요함
        Arrays.sort(arr);

        int start = 0;
        int end = n-1; //arr.length
        while (end > start) {
            int sum = arr[start] + arr[end];

            if (sum > m) {
                end--;
            } else if (sum < m) {
                start++;
            } else {
                count++;
                end--;
                start++;
            }
        }

        System.out.println(count);
    }
}
