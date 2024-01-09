package programmers.level_2.주차_요금_계산;

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
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        // when
        int[] answer = solution.solution(fees, records);

        // then
        assertArrayEquals(new int[]{14600, 34400, 5000}, answer);
    }

    @Test
    void case2() {
        // given
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        // when
        int[] answer = solution.solution(fees, records);

        // then
        assertArrayEquals(new int[]{0, 591}, answer);
    }

    @Test
    void case3() {
        // given
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        // when
        int[] answer = solution.solution(fees, records);

        // then
        assertArrayEquals(new int[]{14841}, answer);
    }
}