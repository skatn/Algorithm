package 알고리즘.병합정렬;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

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
        String input = "8\n1 3 2 5 4 6 8 7".replace("\n", lineSeparator);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                outputStream.toString());
    }

    @Test
    void case2() throws IOException {
        // given
        String input = "8\n1 1 2 1 3 2 1 4".replace("\n", lineSeparator);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 2, 2, 3, 4}),
                outputStream.toString());
    }

    @Test
    void case3() throws IOException {
        // given
        String input = "9\n1 1 2 1 3 2 1 4 5".replace("\n", lineSeparator);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        assertEquals(Arrays.toString(new int[]{1, 1, 1, 1, 2, 2, 3, 4, 5}),
                outputStream.toString());
    }


}