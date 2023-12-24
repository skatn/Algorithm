package beakjoon._1991;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1991 - 트리 순회 (https://www.acmicpc.net/problem/1991)
 * 이진 트리
 */
public class Main {

    // 인접 리스트를 사용 하여 이진 트리 표현
    private static final ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드의 개수는 최대 26개
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }

        // 노드를 알파벳 -> 숫자로 변경 (A => 0, B => 1, C => 2 ... Z => 25)
        // 노드 없음 (.) 은 아스키 코드 에서 A 보다 값이 낮기 때문에 음수로 표현 된다. (A = 65(10), . = 46(10))
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            adjList.get(parent).add(left);
            adjList.get(parent).add(right);
        }

        // 전위 순회
        bw.write(preorder(0));
        bw.write("\n");

        // 중위 순회
        bw.write(inorder( 0));
        bw.write("\n");

        // 후위 순회
        bw.write(postorder( 0));
        bw.write("\n");

        bw.close();
    }

    // 전위 순회, 루트 -> 왼쪽 -> 오른쪽 순으로 탐색 한다.
    private static String preorder(int index) {
        int left = adjList.get(index).get(0);
        int right = adjList.get(index).get(1);
        StringBuilder sb = new StringBuilder();

        sb.append((char)(index + 'A'));
        if (left >= 0) {
            sb.append(preorder(left));
        }
        if (right >= 0) {
            sb.append(preorder(right));
        }

        return sb.toString();
    }

    // 중위 순회, 왼쪽 -> 루트 -> 오른쪽 순으로 탐색 한다.
    private static String inorder(int index) {
        int left = adjList.get(index).get(0);
        int right = adjList.get(index).get(1);
        StringBuilder sb = new StringBuilder();


        if (left >= 0) {
            sb.append(inorder(left));
        }
        sb.append((char)(index + 'A'));
        if (right >= 0) {
            sb.append(inorder(right));
        }

        return sb.toString();
    }

    // 후위 순회, 왼쪽 -> 오른쪽 -> 루트 순으로 탐색 한다.
    private static String postorder(int index) {
        int left = adjList.get(index).get(0);
        int right = adjList.get(index).get(1);
        StringBuilder sb = new StringBuilder();

        if (left >= 0) {
            sb.append(postorder(left));
        }
        if (right >= 0) {
            sb.append(postorder(right));
        }
        sb.append((char)(index + 'A'));

        return sb.toString();
    }
}
