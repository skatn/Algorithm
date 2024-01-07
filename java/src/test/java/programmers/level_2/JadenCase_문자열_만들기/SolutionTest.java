package programmers.level_2.JadenCase_문자열_만들기;

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
        String answer = solution.solution("3people unFollowed me");
        assertEquals("3people Unfollowed Me", answer);
    }

    @Test
    void case2() {
        String answer = solution.solution("for the last week");
        assertEquals("For The Last Week", answer);
    }

    @Test
    void case3() {
        String answer = solution.solution(" for the last week");
        assertEquals(" For The Last Week", answer);
    }

    @Test
    void case4() {
        String answer = solution.solution("3people    unFollowed me");
        assertEquals("3people    Unfollowed Me", answer);
    }

    @Test
    void case5() {
        String answer = solution.solution("  for the what 1what  ");
        assertEquals("  For The What 1what  ", answer);
    }
}