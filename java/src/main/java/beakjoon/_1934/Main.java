package beakjoon._1934;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1934 - 최소공배수 (https://www.acmicpc.net/problem/1934)
 * 풀이 : 유클리드 호제법
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최소공배수 = 두 수의 곱 / 최대공약수
            bw.write(String.valueOf(a * b / gcd(a, b)));
            bw.write("\n");
        }
        bw.close();
    }

    // 유클리드 호제법
    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b, a % b);
    }
}
