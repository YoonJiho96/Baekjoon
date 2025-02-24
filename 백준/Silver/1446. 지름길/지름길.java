import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Shortcut {
        int start, end, cost;

        Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 지름길 개수
        int D = Integer.parseInt(st.nextToken());  // 고속도로 길이

        // 각 위치에서 시작하는 지름길 리스트
        List<Shortcut>[] shortcutsAt = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            shortcutsAt[i] = new ArrayList<>();
        }

        // 지름길 입력 및 유효한 지름길만 저장 (end가 D보다 큰 경우는 무시)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end > D || (end - start) <= cost) continue;
            shortcutsAt[start].add(new Shortcut(start, end, cost));
        }

        // dp[i]: 0부터 i까지 이동했을 때 걸리는 최소 거리
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < D; i++) {
            if (dp[i] + 1 < dp[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }
            for (Shortcut s : shortcutsAt[i]) {
                // 지름길을 탄게 더 빠름
                if (dp[i] + s.cost < dp[s.end]) {
                    dp[s.end] = dp[i] + s.cost;
                }
            }
        }
        System.out.println(dp[D]);
    }
}