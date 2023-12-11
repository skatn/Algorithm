package 알고리즘.퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        // 집합의 원소가 더이상 없으면 종료
        if (start > end) {
            return;
        }

        int left = start + 1;
        int right = end;
        int pivot = arr[start];

        // 피벗을 기준으로 왼쪽이 피벗보다 작은 수, 오른쪽이 피벗보다 큰 수가 오도록 정렬
        while (left < right) { // left, right가 교차하거나 같아질 때 까지 반복
            while(left < end && arr[left] <= pivot) left++;
            while(right > start && arr[right] >= pivot) right--;

            if (left < right) {
                swap(arr, left, right);
            }
        }

        // 피벗 위치 교체
        swap(arr, start, right);

        // 피벗을 기준으로 왼쪽, 오른쪽 집합을 나눔
        quickSort(arr, start, right - 1);
        quickSort(arr, left, end);
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
