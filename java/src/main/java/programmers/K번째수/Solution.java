package programmers.K번째수;

/**
 * 프로그래머스 - K번째수 (https://school.programmers.co.kr/learn/courses/30/lessons/42748)
 */
public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] sort = copyOfRange(array, commands[i][0] - 1, commands[i][1] - 1);
            sort(sort);
            answer[i] = sort[commands[i][2] - 1];
        }

        return answer;
    }

    private int[] copyOfRange(int[] origin, int from, int to) {
        int[] copy = new int[to - from + 1];
        for (int i = from; i <= to; i++) {
            copy[i - from] = origin[i];
        }

        return copy;
    }

    private void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        int l = left;
        int r = mid + 1;
        int s = left;
        int[] sorted = new int[a.length];

        while (l <= mid && r <= right) {
            if(a[l] < a[r]) sorted[s++] = a[l++];
            else sorted[s++] = a[r++];
        }

        while (l <= mid) {
            sorted[s++] = a[l++];
        }
        while (r <= right) {
            sorted[s++] = a[r++];
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}
