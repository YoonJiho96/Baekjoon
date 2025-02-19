import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000009;
    static final int SIZE = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[SIZE + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= SIZE; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % MOD).append("\n");
        }
        System.out.println(sb);
    }
}