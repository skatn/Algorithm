package programmers.level_2._1차_캐시;

import java.util.LinkedList;

/**
 * 프로그래머스 - 1차 캐시 (https://school.programmers.co.kr/learn/courses/30/lessons/17680)
 */
public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                time += 1;
                cache.remove(city);
            } else {
                time += 5;
            }

            cache.add(city);
            if (cache.size() > cacheSize) {
                cache.removeFirst();
            }
        }

        return time;
    }
}
