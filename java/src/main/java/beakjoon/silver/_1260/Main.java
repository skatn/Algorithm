package beakjoon.silver._1260;

import java.io.*;
import java.util.*;

/**
 * 백준 1260 - DFS와 BFS (https://www.acmicpc.net/problem/1260)
 */
public class Main {

    private static final ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
    private static final ArrayList<Boolean> visit = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            edgeList.add(new ArrayList<>());
            visit.add(false);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            edgeList.get(node1).add(node2);
            edgeList.get(node2).add(node1);
        }

        for (int i = 1; i <= N; i++) {
            edgeList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(V);
        for (int i = 1; i <= N; i++) {
            visit.set(i, false);
        }
        System.out.println();
        bfs(V);
    }

    private static void dfs(int node) {
        visit.set(node, true);
        System.out.print(node + " ");
        for (Integer next : edgeList.get(node)) {
            if (!visit.get(next)) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visit.set(node, true);
        queue.add(node);

        while(!queue.isEmpty()) {
            Integer now = queue.remove();
            System.out.print(now + " ");

            for (Integer next : edgeList.get(now)) {
                if (!visit.get(next)) {
                    visit.set(next, true);
                    queue.add(next);
                }
            }
        }
    }
}
