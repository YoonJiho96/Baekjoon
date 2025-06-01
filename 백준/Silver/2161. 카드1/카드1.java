import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        while (!deque.isEmpty()) {
            int num = deque.pollFirst();
            sb.append(num).append(" ");

            if (!deque.isEmpty()) {
                int top = deque.pollFirst();
                deque.offerLast(top);
            }
        }

        System.out.println(sb);
    }
}