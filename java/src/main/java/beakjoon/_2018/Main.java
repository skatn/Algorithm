package beakjoon._2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solution2();
    }

    private static void solution1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;


        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    //투 포인터
    private static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int start = 1;
        int end = 1;

        int sum = 1;

        while (end < n) {
            if (sum < n) {
                sum += ++end;
            } else if (sum > n) {
                sum -= start++;
            } else {
                count++;
                sum += ++end;
            }
        }

        System.out.println(count);
    }


}
