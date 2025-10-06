import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[100001];

        dp[0] = 1;dp[1] = 1;dp[2] = 2;dp[3] = 2;dp[4] = 3;dp[5] = 3;

        int MOD = 1000000009;
        for (int i = 6; i <= 100000; i++) {
            dp[i] = (dp[i - 4] + dp[i - 2] + dp[i - 6]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}