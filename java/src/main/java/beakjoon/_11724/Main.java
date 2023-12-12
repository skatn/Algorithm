package beakjoon._11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11724 - 연결 요소의 개수 (https://www.acmicpc.net/problem/11724)
 * <p>
 *     해당 문제는 몇 개의 그래프로 이루어져 있는지 판단하는 문제이다. <br>
 *     DFS를 사용하여 그래프를 탐색하여 문제를 해결할 수 있다.
 * </p>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 갯수
        int m = Integer.parseInt(st.nextToken()); // 에지 갯수

        int[] visit = new int[n];           // 노드 방문 배열
        int[][] adjMatrix = new int[n][n];  // 인접 행렬을 사용 하여 노드의 엣지를 저장

        // 에지 세팅, 방향이 없는 그래프 이기 때문에 양 쪽 모두 설정
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            adjMatrix[node1][node2] = 1;
            adjMatrix[node2][node1] = 1;
        }

        // 아직 방문 하지 않은 노드가 있으면 그래프 탐색
        int count = 0;
        for (int node = 0; node < visit.length; node++) {
            if (visit[node] == 0) {
                count++;
                DFS(adjMatrix, visit, node);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int[][] adjMatrix, int[] visit, int node) {
        visit[node] = 1; // 현재 노드 방문

        // 현재 노드로 부터 다른 노드로 갈 수 있는 에지가 있고,
        // 아직 방문 하지 않은 노드 라면 해당 노드 방문
        for (int nextNode = 0; nextNode < adjMatrix.length; nextNode++) {
            if (adjMatrix[node][nextNode] == 1 && visit[nextNode] == 0) {
                DFS(adjMatrix, visit, nextNode);
            }
        }
    }
}
