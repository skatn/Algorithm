package programmers.level_2.이진_변환_반복하기;

/**
 * 프로그래머스 - 이진 변환 반복하기 (https://school.programmers.co.kr/learn/courses/30/lessons/70129)
 */
public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int temp = s.replace("0", "").length();
            answer[0]++;
            answer[1] += s.length() - temp;

            s = Integer.toBinaryString(temp);
        }

        return answer;
    }
}
