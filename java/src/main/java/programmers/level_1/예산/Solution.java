package programmers.level_1.예산;

import java.util.Arrays;

/**
 * 프로그래머스 - 예산 (https://school.programmers.co.kr/learn/courses/30/lessons/12982)
 */
public class Solution {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if(budget < 0) break;
            answer++;
        }

        return answer;
    }
}
