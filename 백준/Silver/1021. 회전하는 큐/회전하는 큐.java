import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int count = 0;
        for (int n : nums) {
            int idx = 0;
            for (int x : deque) {
                if (x == n) {
                    break;
                }
                idx++;
            }

            int size = deque.size();
            if (idx <= size / 2) {
                // 왼쪽 회전
                while (deque.peekFirst() != n) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽 회전
                while (deque.peekFirst() != n) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}