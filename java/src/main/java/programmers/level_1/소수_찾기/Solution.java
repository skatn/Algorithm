package programmers.level_1.소수_찾기;

/**
 * 프로그래머스 - 소수 찾기 (https://school.programmers.co.kr/learn/courses/30/lessons/12921)
 */
public class Solution {
    public int solution(int n) {
        int answer = n - 1;
        boolean[] check = new boolean[n + 1];

        for(int i=2; i <= Math.sqrt(n); i++) {
            if(check[i]) continue;

            for(int j = i * i; j <= n; j += i) {
                if(check[j]) continue;

                answer--;
                check[j] = true;
            }
        }

        return answer;
    }
}
