package programmers.PCCP_기출문제_1번_붕대감기;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.level_1.PCCP_기출문제_1번_붕대감기.Solution;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case1() {
        // given
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        // when
        int answer = solution.solution(bandage, health, attacks);

        // then
        assertEquals(5, answer);
    }

    @Test
    void case2() {
        // given
        int[] bandage = {3, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

        // when
        int answer = solution.solution(bandage, health, attacks);

        // then
        assertEquals(-1, answer);
    }

    @Test
    void case3() {
        // given
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

        // when
        int answer = solution.solution(bandage, health, attacks);

        // then
        assertEquals(-1, answer);
    }

    @Test
    void case4() {
        // given
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};

        // when
        int answer = solution.solution(bandage, health, attacks);

        // then
        assertEquals(3, answer);
    }
}