package beakjoon._11689;

import java.util.Scanner;

/**
 * 백준 11689 - GCD(n, k) = 1 (https://www.acmicpc.net/problem/11689)
 * 풀이 : 오일러 피 함수
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;

        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0) {
                    n = n / p;
                }
            }
        }

        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}
