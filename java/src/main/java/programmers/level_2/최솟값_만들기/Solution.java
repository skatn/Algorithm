package programmers.level_2.최솟값_만들기;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 최솟값 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/12941)
 */
public class Solution {

    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        while (!a.isEmpty()) {
            answer += a.remove() * b.remove();
        }

        return answer;
    }
}
