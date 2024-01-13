package beakjoon._1717;

import beakjoon.gold._1717.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void case1() throws Exception {
        // given
        String input = "7 12\n" +
                "0 1 2\n" +
                "0 2 3\n" +
                "1 1 3\n" +
                "0 6 7\n" +
                "1 2 6\n" +
                "0 7 3\n" +
                "0 4 5\n" +
                "0 2 5\n" +
                "1 3 5\n" +
                "1 4 5\n" +
                "1 3 7\n" +
                "1 5 7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\nNO\nYES\nYES\nYES\nYES\n", outputStream.toString());
    }

    @Test
    void case2() throws Exception {
        // given
        String input = "1 1\n" +
                "1 0 1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\n", outputStream.toString());
    }

    @Test
    void case3() throws Exception {
        // given
        String input = "5 5\n" +
                "0 4 5\n" +
                "0 2 3\n" +
                "1 2 5\n" +
                "0 2 4\n" +
                "1 3 5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\nYES\n", outputStream.toString());
    }

}