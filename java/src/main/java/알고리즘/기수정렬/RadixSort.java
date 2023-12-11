package 알고리즘.기수정렬;

import java.util.*;

public class RadixSort {

    public static void sort(int[] arr) {
        ArrayList<Queue<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }

        // 가장 큰 수 찾기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 가장 큰 수의 자릿수 구하기 (e.g. 1, 10, 100 ...)
        int maxDigit = (int)Math.pow(10, (int)Math.log10(max));

        // 기수 정렬 시작
        for (int digit = 1; digit <= maxDigit; digit *= 10) {
            for (int i = 0; i < arr.length; i++) {
                buckets.get(arr[i] / digit % 10).add(arr[i]);
            }

            int arrIndex = 0;
            for (int i = 0; i < buckets.size(); i++) {
                while (!buckets.get(i).isEmpty()) {
                    arr[arrIndex++] = buckets.get(i).remove();
                }
            }
        }
    }
}
