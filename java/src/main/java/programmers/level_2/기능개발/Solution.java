package programmers.level_2.기능개발;

import java.util.ArrayList;

/**
 * 프로그래머스 - 기능개발 (https://school.programmers.co.kr/learn/courses/30/lessons/42586)
 */
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int now = 0;

        while (now < progresses.length) {
            if (progresses[now] >= 100) {
                int count = 0;
                while (now < progresses.length && progresses[now] >= 100) {
                    count++;
                    now++;
                }
                answer.add(count);
            }

            for (int i = now; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
        }

        int[] a = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }

        return a;
    }
}
