package beakjoon.gold._1707;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1707 - 이분 그래프 (https://www.acmicpc.net/problem/1707)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 테스트 케이스 갯수 만큼 반복
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 인접 리스트 초기화
            ArrayList<Integer>[] adjList = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++) {
                adjList[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                adjList[node1].add(node2);
                adjList[node2].add(node1);
            }

            // 이분 그래프 판단
            boolean answer = true;
            int[] visit = new int[v + 1];
            for (int j = 1; j <= v; j++) {
                if (visit[j] == 0) { // 아직 탐색 하지 않은 노드가 있으면 탐색 시작
                    answer = dfs(adjList, visit, j, 1);
                    if (!answer) {
                        break;
                    }
                }
            }
            bw.write(answer ? "YES\n" : "NO\n");
        }

        bw.close();
    }

    /**
     * 이분 그래프 판단
     *
     * @param adjList 인접 리스트
     * @param visit 노드 방문 여부
     * @param node 탐색할 노드
     * @param team 집합 구분 (1, 2)
     * @return 이분 그래프 여부
     */
    static boolean dfs(ArrayList<Integer>[] adjList, int[] visit, int node, int team) {
        visit[node] = team;
        // 현재 노드와 인접한 노드 탐색
        for (int nextNode : adjList[node]) {
            if (visit[nextNode] == team) {      // 현재 노드와 인접한 노드가 같은 집합 이면 이분 그래프가 아니므로 false return
                return false;
            } else if (visit[nextNode] == 0) {  // 아직 방문 하지 않은 노드 라면 방문
                // 이분 그래프가 아닌 것으로 판명 나면 더 이상 탐색할 필요가 없기 때문에 탐색 종료
                if(!dfs(adjList, visit, nextNode, team == 1 ? 2 : 1))
                    return false;
            }
        }
        return true;
    }
}
