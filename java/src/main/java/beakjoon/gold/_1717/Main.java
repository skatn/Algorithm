package beakjoon.gold._1717;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1717 - 집합의 표현 (https://www.acmicpc.net/problem/1717)
 * 알고리즘 : 유니온 파인드
 */
public class Main {

    // 각 노드의 대표 노드를 저장 하는 배열
    // e.g. root[3] = 1 이면 3번 노드의 대표 노드는 1이다.
    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 처음엔 서로 연결된 노드가 없기 때문에 각 노드의 대표 노드는 자기 자신 이다.
        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());      // 연산자 (0: 합집합, 1: 두 노드가 같은 집합?)
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (op == 1) {
                // 두 노드의 대표 노드가 같으면 같은 집합 이다.
                bw.write(find(node1) == find(node2) ? "YES\n" : "NO\n");
            } else {
                // 두 노드의 집합을 하나로 합친다.
                union(node1, node2);
            }
        }

        bw.close();
    }


    // 두 노드의 대표 노드를 통일 한다.
    // 숫자가 낮은 노드가 우선 순위를 가진다. (숫자가 낮은 노드가 대표 노드가 된다.)
    private static void union(int node1, int node2) {
        int rootNode1 = find(node1);
        int rootNode2 = find(node2);

        if (rootNode1 < rootNode2) {
            root[rootNode2] = rootNode1;
        } else {
            root[rootNode1] = rootNode2;
        }
    }

    // 주어진 노드의 대표 노드를 반환 한다.
    private static int find(int node) {
        // 주어진 노드와 대표 노드가 같다면 해당 노드가 대표 노드 이다.
        if (node != root[node]) {
            // 시간 복잡도 최적화를 위한 경로 압축
            root[node] = find(root[node]);
        }
        return root[node];
    }
}
