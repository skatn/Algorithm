package programmers.카펫;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.level_2.카펫.Solution;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void init() {
        solution = new Solution();
    }

    @Test
    void case1() {
        int[] answer = solution.solution(10, 2);
        assertArrayEquals(new int[]{4, 3}, answer);
    }

    @Test
    void case2() {
        int[] answer = solution.solution(8, 1);
        assertArrayEquals(new int[]{3, 3}, answer);
    }

    @Test
    void case3() {
        int[] answer = solution.solution(24, 24);
        assertArrayEquals(new int[]{8, 6}, answer);
    }

    @Test
    void case4() {
        int[] answer = solution.solution(26, 10);
        assertArrayEquals(new int[]{12, 3}, answer);
    }

}