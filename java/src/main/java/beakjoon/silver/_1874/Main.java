package beakjoon.silver._1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 1874 - 스택 수열 (https://www.acmicpc.net/problem/1874)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int num = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String result = null;

        for (int i = 0; i < seq.length; i++) {
            while (num < seq[i]) {
                stack.push(++num);
                sb.append("+\n");
            }
            if (stack.pop() == seq[i]) {
                sb.append("-\n");
            } else {
                result = "NO";
                break;
            }
        }

        if (result == null) {
            result = sb.toString();
        }

        System.out.println(result);
    }
}
