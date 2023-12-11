package beakjoon._2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2751 - 수 정렬하기 2 (https://www.acmicpc.net/problem/2751)
 * <p>
 *     풀이 : N의 개수가 1,000,000개, 시간 제한이 2초이기 때문에 시간 복잡도가 O(nlogn)인 병합 정렬을 사용.
 *     sorted 배열을 merge()메서드 내부에서 선언하면 시간 초과 뜸. 메모리 할당, 해제 작업에 자원 소모가 큰것으로 보임.
 *     그래서 전역 변수로 sorted[]배열 선언해서 사용
 * </p>
 */
public class Main {

    private static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sorted = new int[n];
        mergeSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start == end) return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int sortedIndex = start;

        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] < arr[rightIndex]) {
                sorted[sortedIndex++] = arr[leftIndex++];
            } else {
                sorted[sortedIndex++] = arr[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            sorted[sortedIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= end) {
            sorted[sortedIndex++] = arr[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }
}
