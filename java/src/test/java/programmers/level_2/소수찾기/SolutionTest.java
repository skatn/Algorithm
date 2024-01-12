package programmers.level_2.소수찾기;

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
        int answer = solution.solution("17");
        assertEquals(3, answer);
    }

    @Test
    void case2() {
        int answer = solution.solution("011");
        assertEquals(2, answer);
    }

    @Test
    void case3() {
        int answer = solution.solution("25");
        assertEquals(2, answer);
    }
}