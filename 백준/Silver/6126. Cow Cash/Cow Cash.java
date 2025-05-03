import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());       // target

        int[] coins = new int[V];
        for (int i = 0; i < V; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = c; i <= N; i++) {
                dp[i] += dp[i - c];
            }
        }

        System.out.println(dp[N]);
    }
}