package 알고리즘.퀵정렬;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void case1() {
        int[] arr = {10, 5, 2, 3, 1, 4, 2, 3, 5, 1, 7};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 7, 10}, arr);
    }

    @Test
    void case2() {
        int[] arr = {7, 8, 5, 6, 3, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{2, 3, 5, 6, 7, 8}, arr);
    }
    @Test
    void case3() {
        int[] arr = {2, 3};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{2, 3}, arr);
    }

    @Test
    void case4() {
        int[] arr = {3, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{2, 3}, arr);
    }
    @Test
    void case5() {
        int[] arr = {2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{2}, arr);
    }

}