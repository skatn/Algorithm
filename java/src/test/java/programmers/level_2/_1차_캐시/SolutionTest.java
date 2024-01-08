package programmers.level_2._1차_캐시;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(50, answer);
    }

    @Test
    void case2() {
        // given
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(21, answer);
    }

    @Test
    void case3() {
        // given
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(60, answer);
    }

    @Test
    void case4() {
        // given
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(52, answer);
    }

    @Test
    void case5() {
        // given
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(16, answer);
    }

    @Test
    void case6() {
        // given
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        // when
        int answer = solution.solution(cacheSize, cities);

        // then
        assertEquals(25, answer);
    }

}