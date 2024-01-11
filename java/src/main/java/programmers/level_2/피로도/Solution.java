package programmers.level_2.피로도;

/**
 * 프로그래머스 - 피로도 (https://school.programmers.co.kr/learn/courses/30/lessons/87946)
 */
public class Solution {

    int answer = 0;
    boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return answer;
    }

    private void dfs(int k, int depth, int[][] dungeons) {
        if(answer < depth) answer = depth;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(k - dungeons[i][1],depth + 1, dungeons);
                visit[i] = false;
            }
        }
    }
}
