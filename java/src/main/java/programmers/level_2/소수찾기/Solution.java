package programmers.level_2.소수찾기;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 소수 찾기 (https://school.programmers.co.kr/learn/courses/30/lessons/42839)
 */
public class Solution {
    private boolean[] check;
    private Set<Integer> nums = new HashSet<>();

    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        func(numbers.split(""), "");

        int count = 0;
        for(int n : nums) {
            if(isPrime(n)) count++;
        }
        return count;
    }

    private void func(String[] numbers, String now) {
        for(int i = 0; i < numbers.length; i++) {
            if(!check[i]) {
                check[i] = true;
                nums.add(Integer.parseInt(now + numbers[i]));
                func(numbers, now + numbers[i]);
                check[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }
}
