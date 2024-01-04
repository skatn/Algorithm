package programmers.네트워크;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 네트워크 (https://school.programmers.co.kr/learn/courses/30/lessons/43162)
 */
public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        int[] visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                answer++;
                BFS(i, computers, visit);
            }
        }

        return answer;
    }

    private void BFS(int now, int[][] computers, int[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visit[now] = 1;

        while (!queue.isEmpty()) {
            now = queue.remove();

            for (int i = 0; i < computers[now].length; i++) {
                if (visit[i] == 0 && computers[now][i] == 1) {
                    visit[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}
