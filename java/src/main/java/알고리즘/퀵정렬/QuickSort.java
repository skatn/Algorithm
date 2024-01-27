package 알고리즘.퀵정렬;

public class QuickSort {

    public static void sort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    private static void qs(int[] arr, int start, int end) {
        if(start >= end) return;

        int pivot = start;
        int low = start + 1;
        int high = end;

        while (low <= high) {
            while (low < end && arr[low] <= arr[pivot]) low++;
            while (high > start && arr[high] >= arr[pivot]) high--;

            if(low >= high)
                swap(arr, pivot, high);
            else
                swap(arr, low, high);
        }

        qs(arr, start, high - 1);
        qs(arr, high + 1, end);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
