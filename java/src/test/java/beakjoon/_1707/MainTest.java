package beakjoon._1707;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private ByteArrayOutputStream outputStream;
    private String lineSeparator;

    @BeforeEach
    void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lineSeparator = System.lineSeparator();
    }

    @Test
    void case1() throws IOException {
        // given
        String input = ("2\n" +
                "3 2\n" +
                "1 3\n" +
                "2 3\n" +
                "4 4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 2");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\nNO\n", outputStream.toString());
    }

    @Test
    void case2() throws IOException {
        // given
        String input = ("1\n" +
                "4 3\n" +
                "2 3\n" +
                "3 4\n" +
                "4 2\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\n", outputStream.toString());
    }

    @Test
    void case3() throws IOException {
        // given
        String input = ("1\n" +
                "1 1\n" +
                "1 1\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\n", outputStream.toString());
    }

    @Test
    void case4() throws IOException {
        // given
        String input = ("1\n" +
                "3 1\n" +
                "1 2\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

    @Test
    void case5() throws IOException {
        // given
        String input = ("1\n" +
                "5 2\n" +
                "1 2\n" +
                "2 3\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

    @Test
    void case6() throws IOException {
        // given
        String input = ("1\n" +
                "4 2\n" +
                "1 2\n" +
                "3 4\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }


    @Test
    void case7() throws IOException {
        // given
        String input = ("1\n" +
                "4 3\n" +
                "1 4\n" +
                "2 3\n" +
                "3 4\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

    @Test
    void case8() throws IOException {
        // given
        String input = ("1\n" +
                "5 4\n" +
                "1 2\n" +
                "3 4\n" +
                "3 5\n" +
                "4 5\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\n", outputStream.toString());
    }

    @Test
    void case9() throws IOException {
        // given
        String input = ("1\n" +
                "6 4\n" +
                "1 2\n" +
                "2 4\n" +
                "4 5\n" +
                "5 6\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

    @Test
    void case10() throws IOException {
        // given
        String input = ("1\n" +
                "6 6\n" +
                "1 3\n" +
                "3 4\n" +
                "4 2\n" +
                "2 5\n" +
                "5 6\n" +
                "6 1\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

    @Test
    void case11() throws IOException {
        // given
        String input = ("2\n" +
                "4 4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 1\n" +
                "4 4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 2\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\nNO\n", outputStream.toString());
    }

    @Test
    void case12() throws IOException {
        // given
        String input = ("2\n" +
                "3 3\n" +
                "1 2\n" +
                "2 3\n" +
                "3 1\n" +
                "3 3\n" +
                "1 2\n" +
                "2 3\n" +
                "3 1\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\nNO\n", outputStream.toString());
    }

    @Test
    void case13() throws IOException {
        // given
        String input = ("1\n" +
                "5 4\n" +
                "1 2\n" +
                "3 4\n" +
                "3 5\n" +
                "4 5\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\n", outputStream.toString());
    }

    @Test
    void case14() throws IOException {
        // given
        String input = ("2\n" +
                "3 3\n" +
                "1 2\n" +
                "2 3\n" +
                "1 3\n" +
                "2 1\n" +
                "1 2\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("NO\nYES\n", outputStream.toString());
    }

    @Test
    void case15() throws IOException {
        // given
        String input = ("1\n" +
                "5 4\n" +
                "1 2\n" +
                "1 3\n" +
                "2 4\n" +
                "3 5\n");
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals("YES\n", outputStream.toString());
    }

}