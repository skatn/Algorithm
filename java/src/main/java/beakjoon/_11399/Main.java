package beakjoon._11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11399 - ATM (https://www.acmicpc.net/problem/11399)
 * <p>
 * 풀이 : 버블 정렬, 앞에 있는 사람일 수록 뒷 사람 에게 영향을 많이 끼치기 때문에 앞에 있는 사람일 수록 인출 시간이 작아야 한다.
 * </p>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 인출 하는데 걸리는 시간 오름 차순 정렬 (버블 정렬)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 각 사람마다 기다 려야 하는 시간 누적
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i] * (n - i);
        }
        System.out.println(total);
/*
        // 합 배열을 이용할 수도 있음
        int[] hap = new int[n];
        hap[0] = arr[0];
        for (int i = 1; i < n; i++) {
            hap[i] = hap[i - 1] + arr[i];
        }
        System.out.println(Arrays.stream(hap).sum());
*/
    }
}
