package beakjoon._1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1931 - 회의실 배정 (https://www.acmicpc.net/problem/1931)
 * <p>
 *     회의를 최대한 많이 하기 위해선 회의가 가장 빨리 끝나는 (회의 종료 시간이 낮은) 회의 부터 진행 하면 된다. <br>
 *     그렇기 때문에 회의 종료 시간을 오름 차순 으로 정렬 하고 회의 시간이 겹치지 않는 회의 들을 찾으면 된다. <br>
 *     근데, 해당 문제의 요구 사항 중에 "회의의 시작 시간과 끝나는 시간이 같을 수도 있다" 라는 조건이 있다. <br>
 *     그래서 정렬할 때 종료 시간이 같으면 시작 시간이 빠른 순으로 재 정렬 해줘야 한다. <br>
 *     e.g. [4 => 5], [5 => 5], [2 => 4] 이렇게 회의가 주어 졌을 때 [2 => 4], [4 => 5], [5 => 5]로 정렬 해야 된다.
 * </p>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의가 빨리 끝나는 순으로 정렬
        Arrays.sort(times, (t1, t2) -> {
            if (t1[1] == t2[1]) {       // 회의 종료 시간이 같으면 시작 시간이 빠른 순으로 정렬
                return t1[0] - t2[0];
            } else {
                return t1[1] - t2[1];
            }
        });

        // 회의 시간이 겹치지 않는 회의를 찾는다.
        int count = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            // 회의 시작 시간이 최근 종료된 회의 시간 보다 크거나 같으면 겹치지 않는 회의 이다.
            if (times[i][0] >= time) {
                count++;
                time = times[i][1];
            }
        }
        System.out.println(count);
    }
}
