package programmers.최소직사각형;

/**
 * 프로그래머스 - 최소직사각형 (https://school.programmers.co.kr/learn/courses/30/lessons/86491)
 */
public class Solution {
    public int solution(int[][] sizes) {
        int width = 0;  // 지갑 가로 길이
        int height = 0; // 지갑 세로 길이

        for (int[] size : sizes) {
            // 명함의 가로 길이가 세로 길이 보다 항상 길도록 제한 -> 가로 길이 보다 세로 길이가 더 길면 명함을 눕혀서 지갑에 수납 한다.
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }

            // 명함중 가장 긴 가로 길이
            if (width < size[0]) {
                width = size[0];
            }
            // 명함중 가장 긴 세로 길이
            if (height < size[1]) {
                height = size[1];
            }
        }

        // 만들어진 지갑의 크기
        return width * height;
    }
}
