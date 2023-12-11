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

        int leftIndex = start;
        int rightIndex = mid + 1;

        for (int i = start; i <= end; i++) {
            if (rightIndex > end || leftIndex <= mid && arr[leftIndex] < arr[rightIndex]) {
                sorted[i] = arr[leftIndex];
                leftIndex++;
            } else {
                sorted[i] = arr[rightIndex];
                rightIndex++;
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }
}
