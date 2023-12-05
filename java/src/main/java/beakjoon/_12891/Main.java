package beakjoon._12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> dnaCount = new HashMap<>(Map.of(
                'A', Integer.parseInt(st.nextToken()),
                'C', Integer.parseInt(st.nextToken()),
                'G', Integer.parseInt(st.nextToken()),
                'T', Integer.parseInt(st.nextToken())
        ));
        br.close();

        int result = 0;
        //슬라이딩 윈도우 세팅
        for (int i = 0; i < p; i++) {
            dnaCount.put(dna[i], dnaCount.get(dna[i])-1) ;
        }
        if(check(dnaCount))
            result++;

        for (int start = 0; start < s - p; start++) {
            int end = start + p;
            dnaCount.put(dna[start], dnaCount.get(dna[start])+1);
            dnaCount.put(dna[end], dnaCount.get(dna[end])-1);
            if(check(dnaCount))
                result++;
        }

        System.out.println(result);
    }

    private static boolean check(Map<Character, Integer> dnaCount) {
        for (char key : dnaCount.keySet()) {
            if(dnaCount.get(key) > 0)
                return false;
        }
        return true;
    }
}
