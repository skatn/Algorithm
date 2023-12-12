package beakjoon._1920;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1920 - 수 찾기 (https://www.acmicpc.net/problem/1920)
 * <p>
 * N, M의 갯수가 100,000이고 시간 제한이 1초이기 떄문에 단순 반복문으로 탐색하게 되면 시간 초과. <br>
 * 그래서 시간 복잡도가 O(logN)인 이진 탐색을 사용하고, 이진 탐색을 사용하기 위해 정렬을 해야된다. <br>
 * 정렬도 마찬가지로 시간 복잡도가 O(NlogN)인 병합 정렬을 사용한다.<br>
 * 그렇게되면 총 시간 복잡도는 이진 탐색 O(MlogN) + 병합정렬 O(NlogN)이 된다.
 * </p>
 */
public class Main {

    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        sorted = new int[n];
        mergeSort(a, 0, n - 1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean contains = binarySearch(a, Integer.parseInt(st.nextToken()));
            bw.write(contains ? "1" : "0");
            bw.write("\n");
        }

        bw.close();
    }

    // 이진 탐색 : 찾으려는 값과 데이터셋의 중앙 값을 비교하여 비교 대상을 절반씩 줄여나가면서 탐색
    public static boolean binarySearch(int[] a, int n) {
        int left = 0;
        int right = a.length - 1;

        // left가 right보다 크다는 의미는 더이상 탐색할 데이터가 없다는 것을 의미한다.
        while (left <= right) {
            // 현재 데이터의 중앙값 도출
            int mid = (left + right) / 2;
            int midValue = a[mid];

            if (n < midValue) {         // 찾으려는 값이 중앙값보다 작을 경우 왼쪽 데이터셋 탐색
                right = mid - 1;
            } else if (n > midValue){   // 찾으려는 값이 중앙값보다 클 경우 오른쪽 데이터셋 탐색
                left = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }

    public static void mergeSort(int[] a, int start, int end) {
        if(start == end) return;

        // 데이터셋을 반으로 분리
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        // 데이터셋을 더이상 나눌 수 없을 떄 까지 나눴으면 정렬 진행
        int left = start;
        int right = mid + 1;
        int sortedIndex = start;

        // 두 데이터 집합에서 작은 데이터부터 순서대로 저장
        // 두 집합중 하나라도 저장이 완료되면 종료
        while (left <= mid && right <= end) {
            if(a[left] < a[right]) sorted[sortedIndex++] = a[left++];
            else sorted[sortedIndex++] = a[right++];
        }

        // 왼쪽 집합의 데이터가 남아있으면 순서대로 저장
        while (left <= mid) {
            sorted[sortedIndex++] = a[left++];
        }

        // 오른쪽 집합의 데이터가 남아있으면 순서대로 저장
        while (right <= end) {
            sorted[sortedIndex++] = a[right++];
        }

        // 정렬된 데이터를 배열에 옮김
        for (int i = start; i <= end; i++) {
            a[i] = sorted[i];
        }
    }
}
