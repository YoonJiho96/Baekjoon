import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] cmds = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            BFS(A, B);
        }
        System.out.println(sb);
    }

    static void BFS(int A, int B) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(A);

        boolean[] visited = new boolean[10000];
        String[] cmd = new String[10000];

        visited[A] = true;
        cmd[A] = "";

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == B) {
                sb.append(cmd[cur]).append("\n");
                break;
            }

            int[] nums = {funcD(cur), funcS(cur), funcL(cur), funcR(cur)};
            for (int i = 0; i < 4; i++) {
                int next = nums[i];
                if (!visited[next]) {
                    visited[next] = true;
                    cmd[next] = cmd[cur] + cmds[i];
                    queue.offer(next);
                }
            }
        }
    }

    static int funcD(int n) {
        return (2 * n) % 10000;
    }

    static int funcS(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    static int funcL(int n) {
        int d1 = n / 1000;
        return (n * 10 - d1 * 10000) + d1;
    }

    static int funcR(int n) {
        int temp = n % 1000;
        temp = temp % 100;
        temp = temp % 10;
        return n / 10 + (temp * 1000);
    }
}