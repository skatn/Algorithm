package beakjoon._11720;

import java.util.Scanner;

/**
 * 백준 11720 - 숫자의 합 (https://www.acmicpc.net/problem/11720)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String nums = sc.next();

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += nums.charAt(i) - '0';
        }

        System.out.println(result);
    }
}
