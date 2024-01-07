package programmers.level_2.N개의_최소공배수;

/**
 * 프로그래머스 - N개의 최소공배수 (https://school.programmers.co.kr/learn/courses/30/lessons/12953)
 * <p>
 *     알고리즘 : 유클리드 호제법 <br>
 *     최소공배수 = 두 수의 곱 / 최대공약수
 * </p>
 */
public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        return answer;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
