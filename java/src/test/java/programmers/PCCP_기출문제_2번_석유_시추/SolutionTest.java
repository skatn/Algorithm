package programmers.PCCP_기출문제_2번_석유_시추;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void init() {
        solution = new Solution();
    }

    @Test
    void case1() {
        // given
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        // when
        int answer = solution.solution(land);

        // then
        assertEquals(9, answer);
    }

    @Test
    void case2() {
        // given
        int[][] land = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };

        // when
        int answer = solution.solution(land);

        // then
        assertEquals(16, answer);
    }

}