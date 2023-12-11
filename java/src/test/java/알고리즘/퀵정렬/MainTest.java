package 알고리즘.퀵정렬;

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
        String input = "10,5,2,3,1,4,2,3,5,1,7".replace(",", lineSeparator);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Main.main(null);

        // then
        String expected = "1,1,2,2,3,3,4,5,5,7,".replace(",", lineSeparator);
        assertEquals(expected, outputStream.toString());
    }

}