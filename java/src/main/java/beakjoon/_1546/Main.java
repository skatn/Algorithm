package beakjoon._1546;

import java.util.Scanner;

/**
 * 백준 1546 - 평균 (https://www.acmicpc.net/problem/1546)
 */
public class Main {
    public static void main(String[] args) {
        solution2();
    }

    private static void solution1() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        int max = 0;


        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();

            if (scores[i] > max) {
                max = scores[i];
            }
        }


        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (double) scores[i]/max*100;
        }

        System.out.println(sum/n);
    }

    private static void solution2() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();

            sum += score;
            if (score > max) {
                max = score;
            }
        }

        System.out.println((double) sum/max*100/n);
    }
}
