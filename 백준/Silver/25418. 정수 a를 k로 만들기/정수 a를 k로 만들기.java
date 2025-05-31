import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[K + 1];
        queue.add(A);
        visited[A] = true;

        boolean flag = false;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int num = queue.poll();

                if (num == K) {
                    flag = true;
                    break;
                }

                // 1을 더한 경우
                if (num + 1 <= K && !visited[num + 1]) {
                    queue.offer(num + 1);
                    visited[num + 1] = true;
                }
                
                // 2를 곱한 경우
                if (num * 2 <= K && !visited[num * 2]) {
                    queue.offer(num * 2);
                    visited[num * 2] = true;
                }
            }

            if (flag) break;
            else count++;
        }
        System.out.println(count);
    }
}