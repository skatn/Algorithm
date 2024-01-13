package beakjoon.silver._2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2217 - 로프 (https://www.acmicpc.net/problem/2217)
 * <p>
 *     여러 개의 로프를 사용 하여 물체의 무게를 분산 시켜 들 수 있을 때 주어진 로프 들로 (모든 로프를 사용 하지 않아도 된다.) 들 수 있는 최대 무게를 구하는 문제 이다. <br>
 *     들어 올릴 수 있는 무게가 낮은 로프일 수록 최대한 많은 로프를 사용 해서 무게를 분산 시켜야 한다. <br>
 *     그렇기 때문에 들어 올릴 수 있는 무게가 낮은 것부터 오름 차순 으로 정렬 한다. <br>
 *     들어 올릴 수 있는 무게가 낮은 로프 부터 들어 올릴 수 있는 중량을 계산해 가면서 최대 중량을 도출 한다.
 * </p>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] ropes = new Integer[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // 로프의 들어 올릴 수 있는 무게를 오름 차순 으로 정렬
        Arrays.sort(ropes);

        // 최대 중량 도출
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            // 각 로프에 걸리는 중량 = (현재 중량 / 로프 갯수) 이기 때문에
            // (현재 로프의 감당 가능한 중량 * 사용된 로프 갯수) 식을 사용 하여 최대 중량을 계산할 수 있다.
            // 로프의 중량을 오름 차순 으로 정렬 했기 때문에 사용된 로프 갯수를 (n - i)로 알아 낼 수 있다.
            int currentWeight = ropes[i] * (n - i);
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }

        System.out.println(maxWeight);
    }
}
