import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> reverse = new ArrayDeque<>();
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            if (c == '<') {
                while (!reverse.isEmpty()) {
                    sb.append(reverse.pop());
                }

                stack.push(c);
                sb.append(c);
            } else if (c == '>') {
                stack.clear();
                sb.append(c);
            } else if (c == ' ') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                } else {
                    while (!reverse.isEmpty()) {
                        sb.append(reverse.pop());
                    }
                    sb.append(c);
                }
            } else {
                if (stack.isEmpty()) {
                    reverse.push(c);
                } else {
                    sb.append(c);
                }
            }
        }

        while (!reverse.isEmpty()) {
            sb.append(reverse.pop());
        }

        System.out.println(sb);
    }
}