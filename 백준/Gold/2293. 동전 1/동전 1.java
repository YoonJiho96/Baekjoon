import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            coins[i] = n;
        }

        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[K]);
    }
}