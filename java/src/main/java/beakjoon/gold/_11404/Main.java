package beakjoon.gold._11404;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 11404 - 플로이드 (https://www.acmicpc.net/problem/11404)
 * 플로이드-워셜 알고리즘
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 도시 수
        int m = Integer.parseInt(br.readLine());    // 버스 수
        int[][] d = new int[n][n];                  // 인접 행렬, 각 도시로 갈 수 있는 최소 버스 비용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 도시 수는 최대 100개, 버스 최대 비용은 100,000원 이기 때문에
                    // 도시 100개를 모두 경유 하여도 버스 비용은 9,900,000원이다. (99 * 100,000)
                    // 그래서 무한대 값을 10,000,000으로 지정 (Integer.MAX_VALUE 같은걸 사용 하면 overflow 때문에 값이 엄청 작아짐)
                    d[i][j] = 10000000;
                }
            }
        }

        // 인접 행렬 초기화
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            // 시작 도시와 도착 도시의 노선이 두개 이상일 수 있기 때문에 가장 적은 비용의 노선을 사용
            if (weight < d[start][end]) {
                d[start][end] = weight;
            }
        }

        // 플로이드-워셜
        for (int k = 0; k < n; k++) {           // 경유지
            for (int s = 0; s < n; s++) {       // 출발 도시
                for (int e = 0; e < n; e++) {   // 도착 도시
                    // 출발 도시 에서 도착 도시로 바로 가는 버스 비용 보다
                    // k 도시(경유지)를 거쳐서 가는 버스 비용이 더 쌀 경우 최소 비용 update
                    d[s][e] = Math.min(d[s][e], d[s][k] + d[k][e]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 출발 도시 에서 도착 도시로 갈 수 없는 경우 라면 0을 출력 해야 한다.
                // 노선이 없는 경우 초기화 한 값 10,000,000이 그대로 남아 있기 때문에
                // mod 연산 으로 0을 출력 하도록 했다.
                bw.write(String.valueOf(d[i][j] % 10000000));
                bw.write(" ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
