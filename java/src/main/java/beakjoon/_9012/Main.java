package beakjoon._9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] PSs = new String[n];
        for (int i = 0; i < n; i++) {
            PSs[i] = sc.nextLine();
        }

        String[] result = process(PSs);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] process(String[] PSs) {
        String[] result = new String[PSs.length];

        for (int i = 0; i < PSs.length; i++) {
            result[i] = isVPS(PSs[i]) ? "YES" : "NO";
        }

        return result;
    }

    private static boolean isVPS(String PS) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < PS.length(); i++) {
            char c = PS.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.empty())
                    return false;

                stack.pop();
            }
        }

        return stack.empty();
    }
}
