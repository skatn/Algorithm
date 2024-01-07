package programmers.level_1.PCCP_기출문제_1번_붕대감기;

/**
 * 프로그래머스 - 붕대 감기 (https://school.programmers.co.kr/learn/courses/30/lessons/250137)
 */
public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;           // 마지막 으로 공격 받은 시간
        int maxHealth = health; // 최대 체력

        for (int[] attack : attacks) {
            int temp = attack[0] - time - 1;    // 붕대 감은 시간 계산
            time = attack[0];                   // 마지막 으로 공격 받은 시간 갱신

            // 체력 회복
            // 붕대 감은 시간 * 초당 회복 시간 + (붕대 감은 시간 / 스킬 시전 시간) * 추가 회복량
            // => 붕대 감은 시간 * 초당 회복 시간 + 스킬 완료 횟수 * 추가 회복량
            health += temp * bandage[1] + (temp/bandage[0]) * bandage[2];
            if (health > maxHealth) {
                health = maxHealth;
            }

            health -= attack[1];
            if(health <= 0) return -1;
        }

        return health;
    }
}
