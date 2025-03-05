import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 0: 굶, 1 ~ 4 : 그 식당 이용 가능한 경우의 수
        long[][] dp = new long[N][5];

        // 첫 날 모든 경우 가능
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;

        for (int i = 1; i < N; i++) {
            // 굶는 경우는 1,2,3,4 가 있는 경우 가능
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD;

            // 각각 전날 가게 + 양 옆 제외
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][4]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][4]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        }

        System.out.println(Arrays.stream(dp[N - 1]).sum() % MOD);
    }
}