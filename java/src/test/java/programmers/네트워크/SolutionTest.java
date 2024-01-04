package programmers.네트워크;

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
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        // when
        int answer = solution.solution(n, computers);

        // then
        assertEquals(2, answer);
    }

    @Test
    void case2() {
        // given
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        // when
        int answer = solution.solution(n, computers);

        // then
        assertEquals(1, answer);
    }

}