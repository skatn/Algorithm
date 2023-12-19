package beakjoon._11657;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 11657 - 타임머신 (https://www.acmicpc.net/problem/11657)
 * 벨만-포드 알고리즘
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edgeList = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(start, end, weight);
        }

        // 각 노드의 최단 경로 배열
        long[] distance = new long[n + 1];
        for (int i = 2; i <= n; i++) {      // 시작 노드(1)를 제외한 노드의 최단 경로를 최대한 큰 값으로 초기화
            distance[i] = Long.MAX_VALUE;
        }

        // 시작 노드 부터 가장 멀리 있는 노드 까지 가는 최악의 에지 수는 노드 개수 - 1 이다.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edgeList) {
                // 아직 최단 경로가 구해 지지 않은 노드 라면 pass
                if(distance[edge.getStart()] == Long.MAX_VALUE) continue;

                // 현재 계산된 최단 경로 보다 더 빠른 경로가 있다면 update
                if (distance[edge.getStart()] + edge.getWeight() < distance[edge.getEnd()]) {
                    distance[edge.getEnd()] = distance[edge.getStart()] + edge.getWeight();
                }
            }
        }

        // 최단 경로 탐색을 1번 더 했을 때 새로운 최단 경로가 나온 다면 음수 사이클이 존재 한다.
        for (Edge edge : edgeList) {
            if(distance[edge.getStart()] == Long.MAX_VALUE) continue;

            if (distance[edge.getStart()] + edge.getWeight() < distance[edge.getEnd()]) {
                bw.write("-1");
                bw.close();
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (distance[i] == Long.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(String.valueOf(distance[i]));
                bw.write("\n");
            }
        }

        bw.close();
    }
}

class Edge {
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
