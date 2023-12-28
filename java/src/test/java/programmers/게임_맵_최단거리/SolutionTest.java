package programmers.게임_맵_최단거리;

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
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        // when
        int answer = solution.solution(maps);

        // then
        assertEquals(11, answer);
    }

    @Test
    void case2() {
        // given
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        // when
        int answer = solution.solution(maps);

        // then
        assertEquals(-1, answer);
    }

}