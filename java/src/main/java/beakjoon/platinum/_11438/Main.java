package beakjoon.platinum._11438;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 11438 - LCA 2 (https://www.acmicpc.net/problem/11438)
 * 알고리즘 : LCA 빠르게 구하기
 */
public class Main {

    private static ArrayList<Integer>[] tree;
    private static int[][] parent; // parent[K][V] : 노드 V의 2^K 번째 조상 노드
    private static int[] depth; // 각 노드의 깊이
    private static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        depth = new int[N + 1];

        // 주어진 노드로 만들 수 있는 트리의 최대 높이를 표현할 수 있는 2의 거듭 제곱수 찾기
        // 예를 들어 노드의 개수가 10이면 트리의 최대 높이는 10. 따라서 k는 4 (2^3 = 8, 2^4 = 16)
        int temp = 1;
        while (temp < N) {
            temp <<= 1; // temp *= 2
            K++;
        }
        parent = new int[K + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // BFS로 각 노드별 깊이, 부모 노드 저장
        bfs(1);

        // 각 노드의 2^K 번째 부모 노드 저장
        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(findLCA(node1, node2)));
            bw.write("\n");
        }
        bw.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        depth[node] = 1;

        while (!queue.isEmpty()) {
            Integer nowNode = queue.remove();
            for (Integer nextNode : tree[nowNode]) {
                if (depth[nextNode] == 0) {
                    depth[nextNode] = depth[nowNode] + 1;
                    parent[0][nextNode] = nowNode;
                    queue.add(nextNode);
                }
            }
        }
    }

    private static int findLCA(int node1, int node2) {
        // 깊이 맞추기. 항상 node2의 depth가 더 크도록 설정
        if (depth[node1] > depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        // node2의 depth가 node1의 depth와 같아질 때 까지 2^K 만큼 점프
        for (int k = K; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[node2] - depth[node1]) {
                node2 = parent[k][node2];
            }
        }

        // 깊이를 통일 했는데 두 노드가 같은 노드 라면 바로 종료
        if(node1 == node2) return node1;

        // 공통 조상 찾기
        // 공통 조상의 바로 아래 깊이 까지 점프
        for (int k = K; k >= 0; k--) {
            if (parent[k][node1] != parent[k][node2]) {
                node1 = parent[k][node1];
                node2 = parent[k][node2];
            }
        }

        // 공통 조상 바로 아래 까지 점프 했기 때문에 부모 노드 return
        return parent[0][node1];
    }
}
