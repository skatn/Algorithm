package programmers.더_맵게;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;
    Random random;

    @BeforeEach
    void init() {
        solution = new Solution();
        random = new Random();
    }

    @Test
    void case1() {
        // given
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        // when
        int answer = solution.solution(scoville, K);

        // then
        assertEquals(2, answer);
    }

    @Test
    void case2() {
        // given
        int[] scoville = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            scoville[i] = 1;
        }
        int K = 1000000000;

        // when
        int answer = solution.solution(scoville, K);

        // then
        assertEquals(999998, answer);
    }

    @Test
    void case3() {
        // given
        int[] scoville = {0, 90, 80, 19, 12, 51, 32, 91, 53, 5, 79, 2, 37, 12, 37, 18, 75, 19, 36, 58, 57, 12, 22, 44, 62, 59, 74, 10, 22, 18, 58, 54, 75, 24, 24, 72, 30, 40, 75, 77, 39, 53, 44, 13, 23, 9, 98, 81, 18, 2, 15, 4, 72, 1, 78, 65, 37, 54, 45, 6, 29, 57, 57, 87, 0, 88, 73, 32, 51, 37, 64, 89, 84, 0, 99, 70, 68, 42, 71, 88, 45, 65, 68, 71, 96, 0, 74, 13, 81, 9, 25, 68, 2, 62, 44, 52, 27, 78, 4, 44};
        int K = 63;

        // when
        int answer = solution.solution(scoville, K);

        // then
        assertEquals(42, answer);
    }

    @Test
    void case4() {
        // given
        int[] scoville = {2, 9, 3, 0, 0, 2, 9, 0, 6, 6};
        int K = 3;

        // when
        int answer = solution.solution(scoville, K);

        // then
        assertEquals(4, answer);
    }

}