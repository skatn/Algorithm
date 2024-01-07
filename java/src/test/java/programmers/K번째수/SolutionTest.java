package programmers.K번째수;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.level_1.K번째수.Solution;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void solution() {
        int[] answer = solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        assertArrayEquals(new int[]{5, 6, 3}, answer);
    }
}