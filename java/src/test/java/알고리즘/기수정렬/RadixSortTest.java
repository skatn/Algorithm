package 알고리즘.기수정렬;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void case1() {
        //given
        int[] arr = {1, 3, 5, 323, 2, 99, 1};

        //when
        RadixSort.sort(arr);

        //then
        assertArrayEquals(new int[]{1, 1, 2, 3, 5, 99, 323},
                arr);
    }

    @Test
    void case2() {
        //given
        int[] arr = {6012, 3148, 5939, 1707, 9838, 220, 6450, 1749, 3338, 4317, 1879, 2100, 9514, 3043, 578, 235, 2769, 5111, 2300, 9184, 6035, 7138, 7146, 4577, 8508, 4379, 9544, 7869, 272, 5428, 6717, 9464, 1644, 1332, 111, 1851, 8214, 1757, 7768, 4967};

        //when
        RadixSort.sort(arr);

        //then
        assertArrayEquals(new int[]{111, 220, 235, 272, 578, 1332, 1644, 1707, 1749, 1757, 1851, 1879, 2100, 2300, 2769, 3043, 3148, 3338, 4317, 4379, 4577, 4967, 5111, 5428, 5939, 6012, 6035, 6450, 6717, 7138, 7146, 7768, 7869, 8214, 8508, 9184, 9464, 9514, 9544, 9838},
                arr);
    }

    @Test
    void case3() {
        //given
        Random random = new Random();
        int[] arr = new int[10000000];
        int[] expected = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            expected[i] = arr[i];
        }

        //when
        RadixSort.sort(arr);

        //then
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }
}