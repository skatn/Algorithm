package programmers.level_2.피로도;

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
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        // when
        int answer = solution.solution(k, dungeons);

        // then
        assertEquals(3, answer);
    }
}