package beakjoon.silver._11725;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 11725 - 트리의 부모 찾기 (https://www.acmicpc.net/problem/11725)
 * 알고리즘 : BFS
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());                    // 노드 개수
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  // 인접 리스트
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }

        int[] parent = new int[N + 1];              // 각 노드의 부모 노드 배열
        Queue<Integer> queue = new LinkedList<>();  // BFS 큐
        queue.add(1);   // 루트 노드 에서 BFS 탐색 시작
        parent[1] = 1; // parent 배열을 visit 의미 로도 사용 하기 때문에 다시 방문 하는 것을 방지 하기 위함

        while (!queue.isEmpty()) {
            // 탐색 기준 노드
            Integer node = queue.remove();

            // 주변 노드 탐색
            for (Integer nextNode : adjList.get(node)) {
                // 다음 노드의 부모 노드가 0 이라는 것은 아직 탐색 하지 않은 노드
                if (parent[nextNode] == 0) {
                    parent[nextNode] = node; // 다음 노드의 부모 노드를 현재 노드로 지정
                    queue.add(nextNode);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.write("\n");
        }
        bw.close();
    }
}
