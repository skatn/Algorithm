package beakjoon._1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1197 - 최소 스패닝 트리 (https://www.acmicpc.net/problem/1197)
 * <p>
 *     최소 신장 트리는 모든 노드를 연결 할 수 있는 최소 한의 에지를 사용 하고 그 중에서 가중치가 가장 낮은 에지만 사용 한다. <br>
 *     트리 구조를 갖기 위해선 사이클이 없어야 되기 때문에 유니온-파인드 알고리즘을 함께 사용한다.
 * </p>
 */
public class Main {

    // 최소 신장 트리(MST)는 엣지 리스트를 사용 한다.
    // 가중치가 낮은 에지 부터 사용 하기 때문에 우선 순위 큐를 사용 한다.
    private static PriorityQueue<Edge> edgeList;

    // 유니온 파인드 배열
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edgeList = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            // 우선 순위 큐에 추가 하면서 자동 정렬
            edgeList.add(new Edge(s, e, w));
        }

        int count = 0;  // 사용된 에지 수
        int answer = 0;
        while (count < V - 1) {
            Edge edge = edgeList.remove();

            // 두 노드 집합의 대표 노드가 같다면 하나로 합치게 될 때 사이클이 생성 된다는 의미 이다.
            if(find(edge.start) != find(edge.end)){
                union(edge.start, edge.end);    // 두 노드의 집합을 하나로 합친다.
                answer += edge.weight;
                count++;
            }
        }

        System.out.println(answer);
    }

    public static void union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent < node2Parent) {
            parent[node2Parent] = node1Parent;
        } else {
            parent[node1Parent] = node2Parent;
        }
    }

    public static int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }


    public static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
}
