package programmers.카펫;

/**
 * 프로그래머스 - 카펫 (https://school.programmers.co.kr/learn/courses/30/lessons/42842)
 */
public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {3, 3};

        while (answer[0] * answer[1] != brown + yellow || (answer[0]-2) * (answer[1]-2) != yellow) {
            if (answer[0] == answer[1]) {
                answer[0]++;
                answer[1] = 3;
            } else {
                answer[1]++;
            }
        }

        return answer;
    }
}
