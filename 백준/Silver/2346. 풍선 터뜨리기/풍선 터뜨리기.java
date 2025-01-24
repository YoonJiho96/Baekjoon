import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            sb.append(current[0]).append(" ");

            int move = current[1];
            if (deque.isEmpty()) break;

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}