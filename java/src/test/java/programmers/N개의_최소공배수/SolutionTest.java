package programmers.N개의_최소공배수;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.level_2.N개의_최소공배수.Solution;

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
        int[] arr = {2, 6, 8, 14};

        // when
        int answer = solution.solution(arr);

        // then
        assertEquals(168, answer);
    }

    @Test
    void case2() {
        // given
        int[] arr = {1, 2, 3};

        // when
        int answer = solution.solution(arr);

        // then
        assertEquals(6, answer);
    }

    @Test
    void case3() {
        // given
        int[] arr = {3, 5, 7, 9};

        // when
        int answer = solution.solution(arr);

        // then
        assertEquals(315, answer);
    }

    @Test
    void case4() {
        // given
        int[] arr = {24, 40, 50};

        // when
        int answer = solution.solution(arr);

        // then
        assertEquals(answer, 600);
    }

    @Test
    void case5() {
        // given
        int[] arr = {12, 44, 10, 8, 18, 20, 26};

        // when
        int answer = solution.solution(arr);

        // then
        assertEquals(51480, answer);
    }

}