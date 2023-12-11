package 알고리즘.병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sorted = new int[n];
        mergeSort(arr, 0, n - 1);
        System.out.print(Arrays.toString(arr));
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

        // 분할된 두 집합을 하나로 합치 면서, 둘중 하나 라도 병합이 완료 되면 종료
        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] < arr[rightIndex]) {
                sorted[sortedIndex++] = arr[leftIndex++];
            } else {
                sorted[sortedIndex++] = arr[rightIndex++];
            }
        }

        // 왼쪽 집합의 남은 원소 추가
        while (leftIndex <= mid) {
            sorted[sortedIndex++] = arr[leftIndex++];
        }

        // 오른쪽 집합의 남은 원소 추가
        while (rightIndex <= end) {
            sorted[sortedIndex++] = arr[rightIndex++];
        }

        // 정렬된 데이터를 배열에 옮김
        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }
}
