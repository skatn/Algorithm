package programmers.level_2.짝지어_제거하기;

import java.util.Stack;

/**
 * 프로그래머스 - 짝지어 제거하기 (https://school.programmers.co.kr/learn/courses/30/lessons/12973)
 */
public class Solution {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
