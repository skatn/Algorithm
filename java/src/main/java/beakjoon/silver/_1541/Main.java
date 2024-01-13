package beakjoon.silver._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1541 - 잃어버린 괄호 (https://www.acmicpc.net/problem/1541)
 * <p>
 *     빼려는 값이 클수록 수식의 결과는 최소가 된다. <br>
 *     그래서 (-) 뒤에 있는 수가 커지 도록 하려면 (-) 뒤의 수식 들을 먼저 계산 해야 된다. => + 연산을 먼저 수행 한다. <br>
 *     예를 들어 1+22-3+55+21-10+3 이런 수식이 있을 때 (1+22)-(3+55+21)-(10+3) 이렇게 계산이 이루어 진다. <br>
 * </p>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 0;

        // "-"기호를 기준 으로 수식을 나눈다. => (+) 연산 끼리 묶인다.
        String[] minus = s.split("-");
        for (int i = 0; i < minus.length; i++) {
            // (+) 연산을 해준다.
            int sum = 0;
            String[] plus = minus[i].split("\\+");
            for (int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt(plus[j]);
            }

            // 각 그룹 들의 (+) 결과를 빼준다.
            if(i == 0) answer += sum;   // 만약 첫 수식 이면 answer에 더해 준다.
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
