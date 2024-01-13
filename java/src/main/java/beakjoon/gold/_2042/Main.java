package beakjoon.gold._2042;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2042 - 구간 합 구하기 (https://www.acmicpc.net/problem/2042)
 * 알고리즘 : 세그먼트 트리
 */
public class Main {
    private static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수(노드)의 개수
        int M = Integer.parseInt(st.nextToken()); // update 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간 합 연산 횟수

        // 트리 높이 구하기
        int treeHeight = 1;
        while (Math.pow(2, treeHeight) < N) {
            treeHeight++;
        }
        final int leafNodeStartIndex = (int) Math.pow(2, treeHeight); // 리프 노드 (실제 데이터 노드) 시작 인덱스

        // 데이터 입력
        segmentTree = new long[leafNodeStartIndex * 2];
        for (int i = 0; i < N; i++) {
            segmentTree[i + leafNodeStartIndex] = Long.parseLong(br.readLine());
        }

        // 트리 초기화
        for (int i = segmentTree.length - 1; i > 1; i--) {
            segmentTree[i / 2] += segmentTree[i];
        }


        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // update, 실제 데이터는 leaf 노드 이기 때문에 입력 받은 데이터 위치 -> 리프 노드 위치로 변환 해서 넘겨줌
                update(b + leafNodeStartIndex - 1, c);
            } else {
                // 구간 합, 실제 데이터는 leaf 노드 이기 때문에 입력 받은 데이터 위치 -> 리프 노드 위치로 변환 해서 넘겨줌
                long result = sum(b + leafNodeStartIndex - 1, (int) c + leafNodeStartIndex - 1);
                bw.write(String.valueOf(result));
                bw.write("\n");
            }
        }
        bw.close();
    }

    // 데이터 변경이 일어날 땐 데이터 변화량을 계산 하고 부모 노드를 거슬러 올라 가면서 모두 변화량을 더해 준다.
    private static void update(int index, long value) {
        long diff = value - segmentTree[index];
        while (index > 0) {
            segmentTree[index] += diff;
            index = index / 2;
        }
    }

    // 구간 합
    private static long sum(int start, int end) {
        long result = 0;
        // 포인터가 교차 되면 종료
        while (start <= end) {
            // 두 자식 노드 중 오른 쪽 노드를 사용 한다는 의미는 현재 노드의 부모 노드를 사용 할수 없기 때문에 현재 노드를 선택 한다.
            if (start % 2 == 1) {
                result += segmentTree[start];
            }
            // 두 자식 노드 중 왼쪽 노드를 사용 한다는 의미는 현재 노드의 부모 노드를 사용 할수 없기 때문에 현재 노드를 선택 한다.
            if (end % 2 == 0) {
                result += segmentTree[end];
            }
            // 부모 노드로 포인터 이동
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return result;
    }
}
