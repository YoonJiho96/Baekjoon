import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        // 이동 집합 M = {1, 1+a, 1+b}
        int[] moves = Arrays.stream(new int[]{1, 1 + a, 1 + b})
                .distinct().sorted().toArray();

        int INF = 1_000_000_007;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x = 1; x <= N; x++) {
            for (int k : moves) {
                if (k > x) break;
                dp[x] = Math.min(dp[x], dp[x - k] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}