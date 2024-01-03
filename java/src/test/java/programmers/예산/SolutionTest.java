package programmers.예산;

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
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        // when
        int answer = solution.solution(d, budget);

        // then
        assertEquals(3, answer);
    }

    @Test
    void case2() {
        // given
        int[] d = {2, 2, 3, 3};
        int budget = 10;

        // when
        int answer = solution.solution(d, budget);

        // then
        assertEquals(4, answer);
    }

    @Test
    void case3() {
        // given
        int[] d = {1, 1, 1, 1, 2, 4, 5};
        int budget = 9;

        // when
        int answer = solution.solution(d, budget);

        // then
        assertEquals(5, answer);
    }

    @Test
    void case4() {
        // given
        int[] d = {1, 1, 1, 1, 1, 2, 3, 4};
        int budget = 9;

        // when
        int answer = solution.solution(d, budget);

        // then
        assertEquals(6, answer);
    }

    @Test
    void case5() {
        // given
        int[] d = {1, 1, 1, 1, 2, 2, 3, 3, 5};
        int budget = 10;

        // when
        int answer = solution.solution(d, budget);

        // then
        assertEquals(6, answer);
    }
}