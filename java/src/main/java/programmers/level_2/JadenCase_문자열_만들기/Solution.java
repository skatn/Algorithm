package programmers.level_2.JadenCase_문자열_만들기;

/**
 * 프로그래머스 - JadenCase 문자열 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/12951)
 */
public class Solution {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 || chars[i - 1] == ' ') && chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            }
        }

        return String.valueOf(chars);
    }
}
