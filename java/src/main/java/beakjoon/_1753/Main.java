package beakjoon._1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1753 - 최단경로 (https://www.acmicpc.net/problem/1753)
 * 다익스트라, 우선순위 큐
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        int[] visit = new int[v + 1];       // 노드 방문 배열
        int[] distance = new int[v + 1];    // 시작 노드와 특정 노드 까지의 최단 거리 배열
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
            distance[i] = v * 10;           // 시작 노드와 특정 노드 까지 거리를 최대 거리로 초기화
        }
        distance[startNode] = 0;            // (시작 노드 -> 시작 노드) 최단 거리를 0으로 초기화

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        // 우선 순위 큐를 사용 하여 최단 거리 탐색
        //   - 시작 노드로 부터 거리가 가까운 노드 부터 연산
        //   - int[]{시작 노드와 현재 노드 까지의 거리, 현재 노드 번호}
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n[0]));
        queue.add(new int[]{0, startNode});

        while (!queue.isEmpty()) {
            int node = queue.remove()[1];
            if(visit[node] == 1) continue;  // 이미 방문한 노드 (이미 최단 경로가 구해진 노드) 라면 skip
            visit[node] = 1;

            for (Node nextNode : graph.get(node)) {
                // 시작 노드 에서 다음 노드 까지의 거리가 현재 노드 를 거쳐 다음 노드를 가는 것이 더 빠른 경로 라면 최단 경로 update
                if (distance[node] + nextNode.getWeight() < distance[nextNode.getNode()]) {
                    distance[nextNode.getNode()] = distance[node] + nextNode.getWeight();
                    queue.add(new int[]{distance[nextNode.getNode()], nextNode.getNode()});
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            bw.write(visit[i] == 0 ? "INF" : String.valueOf(distance[i]));
            bw.write("\n");
        }

        bw.close();
    }
}

class Node {
    private int node;
    private int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}
