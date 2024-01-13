package beakjoon.gold._11437;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 11437 - LCA (https://www.acmicpc.net/problem/11437)
 * <p>
 *     LCA(Lowest Common Ancestor)란 트리 에서 최소 공통 조상을 찾는 알고리즘을 말한다. <br>
 *     쉽게 말해 두 노드의 마지막 분기점을 찾는 알고리즘 이다.
 * </p>
 */
public class Main {

    private static final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static int[] parent;    // 각 노드의 부모 노드를 저장 하는 배열
    private static int[] depth;     // 각 노드의 깊이를 저장 하는 배열

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree.get(s).add(e);
            tree.get(e).add(s);
        }

        parent[1] = 1;
        depth[1] = 1;
        dfs(1, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            bw.write(String.format("%d\n", findLCA(node1, node2)));
        }
        bw.close();
    }

    // 깊이 우선 탐색을 이용 하여 각 노드의 부모 노드, 깊이를 저장
    private static void dfs(int node, int dep) {
        for (Integer nextNode : tree.get(node)) {
            if (depth[nextNode] == 0) {     // 깊이가 0이면 아직 방문 하지 않은 노드 이다.
                parent[nextNode] = node;    // 다음 노드 (자식 노드)의 부모 노드를 현재 노드로 설정 한다.
                depth[nextNode] = dep + 1;  // 다음 노드 (자식 노드)의 깊이를 현재 노드의 깊이 + 1 로 설정 한다.
                dfs(nextNode, dep + 1);
            }
        }
    }

    private static int findLCA(int node1, int node2) {
        // 두 노드의 깊이를 동일 하게 만들어 준다.
        // 두 노드 중 깊이가 더 깊은 노드가 부모 노드로 거슬러 올라 간다.
        while (depth[node1] > depth[node2]) {
            node1 = parent[node1];
        }
        while (depth[node1] < depth[node2]) {
            node2 = parent[node2];
        }

        // 두 노드가 같은 노드가 될 때 까지 부모 노드로 거슬러 올라 간다.
        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        // 두 노드가 같은 노드를 가리 키게 되면 해당 노드가 최소 공통 조상 이다.
        return node1;
    }
}
