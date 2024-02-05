package programmers.level_1.모의고사;

import java.util.ArrayList;

/**
 * 프로그래머스 - 모의고사 (https://school.programmers.co.kr/learn/courses/30/lessons/42840)
 */
public class Solution {
    public int[] solution(int[] answers) {
        int[][] p = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[p.length];

        int max = 0;
        for(int i=0; i<p.length; i++) {
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == p[i][j % p[i].length]) {
                    scores[i]++;
                }
            }

            if(max < scores[i]) {
                max = scores[i];
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<scores.length; i++) {
            if(scores[i] == max) {
                temp.add(i);
            }
        }

        return temp.stream().mapToInt(i -> i + 1).toArray();
    }
}
