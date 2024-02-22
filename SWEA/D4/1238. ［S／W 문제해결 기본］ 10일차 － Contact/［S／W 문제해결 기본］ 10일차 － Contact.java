import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T = 10;
    static int L, V, result;
    static List<List<Integer>> input;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            input = new ArrayList<>();
            visit = new boolean[101];

            for (int i = 0; i <= 100; i++) {
                input.add(new ArrayList<>());
            }

            // 입력 초기화
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                input.get(from).add(to);
            }

            // 풀이
            result = 0;
            bfs(V);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visit[v] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int n : input.get(cur)) {
                    if (visit[n])
                        continue;
                    visit[n] = true;
                    queue.offer(n);
                    max = Math.max(max, n);
                    result = max;
                }
            }
        }
    }
}