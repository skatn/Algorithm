package programmers.level_3.가장_먼_노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 가장 먼 노드 (https://school.programmers.co.kr/learn/courses/30/lessons/49189)
 */
public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            adjList.get(e[0] - 1).add(e[1] - 1);
            adjList.get(e[1] - 1).add(e[0] - 1);
        }

        boolean[] visit = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1});
        visit[0] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            if (distance != now[1]) {
                distance = now[1];
                answer = 0;
            }
            answer++;

            for (int nextNode : adjList.get(now[0])) {
                if (!visit[nextNode]) {
                    queue.add(new int[]{nextNode, now[1] + 1});
                    visit[nextNode] = true;
                }
            }
        }

        return answer;
    }
}
