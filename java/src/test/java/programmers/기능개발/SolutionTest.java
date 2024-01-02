package programmers.기능개발;

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
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        // when
        int[] answer = solution.solution(progresses, speeds);

        // then
        assertArrayEquals(new int[]{2, 1}, answer);
    }

    @Test
    void case2() {
        // given
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        // when
        int[] answer = solution.solution(progresses, speeds);

        // then
        assertArrayEquals(new int[]{1, 3, 2}, answer);
    }
}