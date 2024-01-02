package 알고리즘.퀵정렬;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void case1() {
        int[] arr = {10, 5, 2, 3, 1, 4, 2, 3, 5, 1, 7};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 7, 10}, arr);
    }

}