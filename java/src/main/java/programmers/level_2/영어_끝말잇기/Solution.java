package programmers.level_2.영어_끝말잇기;

import java.util.LinkedList;

/**
 * 프로그래머스 - 영어 끝말잇기 (https://school.programmers.co.kr/learn/courses/30/lessons/12981)
 */
public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        LinkedList<String> uses = new LinkedList<>();
        char last = words[0].charAt(words[0].length() - 1);
        uses.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(last != words[i].charAt(0) || uses.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            last = words[i].charAt(words[i].length() - 1);
            uses.add(words[i]);
        }

        return answer;
    }
}
