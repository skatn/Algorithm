package beakjoon.silver._10816;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 10816 - 숫자 카드 2 (https://www.acmicpc.net/problem/10816)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bw.write(String.valueOf(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)));
            bw.write(" ");
        }

        bw.close();
    }
}
