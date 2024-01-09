package programmers.level_2.주차_요금_계산;

import java.util.TreeMap;

/**
 * 프로그래머스 - 주차 요금 계산 (https://school.programmers.co.kr/learn/courses/30/lessons/92341)
 */
public class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> totalTime = new TreeMap<>(); // 차량 번호를 오름차순으로 정렬하기 위해 TreeMap 사용

        for (String record : records) {
            String[] temp = record.split(" ");

            // 입차 했으면 총 누적 시간을 뺴고, 출차 했으면 총 누적 시간을 더함
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= time2minutes(temp[0]);
            totalTime.put(temp[1], time + totalTime.getOrDefault(temp[1], 0));
        }

        int index = 0;
        int[] answer = new int[totalTime.size()];
        for (int time : totalTime.values()) {
            if(time < 1) time += 1439; // 누적 주차 시간이 음수면 아직 출차 하지 않은 차량이므로 23:59분에 출차한것으로 간주
            answer[index++] =  fees[1] + (int) Math.max(0, Math.ceil((time - (double) fees[0]) / fees[2]) * fees[3]);
        }

        return answer;
    }

    private int time2minutes(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
