import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] cmd = br.readLine().toCharArray();

            int n = Integer.parseInt(br.readLine());

            String inputs = br.readLine();
            inputs = inputs.substring(1);
            inputs = inputs.substring(0, inputs.length() - 1);

            String[] temp = inputs.split(",");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (String s : temp) {
                if (s.isEmpty()) continue;
                deque.offer(Integer.parseInt(s));
            }

            // 1 정방향, -1 역방향
            int dir = 1;
            boolean valid = true;
            for (char c : cmd) {
                if (c == 'R') {
                    dir *= -1;
                } else {
                    if (deque.isEmpty()) {
                        valid = false;
                        break;
                    } else {
                        if (dir == 1) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                }
            }

            if (valid) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (dir == 1) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
            } else {
                sb.append("error");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}