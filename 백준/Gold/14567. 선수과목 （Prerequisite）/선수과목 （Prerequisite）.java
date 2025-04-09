import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        int[] semester = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B); // A가 선행이 되는 과목 리스트
            indegree[B]++;  // B가 가지는 선행과목 수
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 위상 정렬
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                semester[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    semester[next] = semester[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }
        System.out.println(sb);
    }
}