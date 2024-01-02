package programmers.같은_숫자는_싫어;

import java.util.Stack;

/**
 * 프로그래머스 - 같은 숫자는 싫어 (https://school.programmers.co.kr/learn/courses/30/lessons/12906)
 */
public class Solution {

    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if(stack.empty() || stack.peek() != i)
                stack.push(i);
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

}
