import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX + 1];
        int[] prefix = new int[MAX + 1]; // prefix[i] = dp[0] + dp[1] + ... + dp[i]

        dp[0] = 1;
        prefix[0] = 1;

        for (int n = 1; n <= MAX; n++) {
            int limit = (n - 1) / 2; // floor((n-1)/2)
            int sum = prefix[limit]; // dp[0] + dp[1] + ... + dp[limit]
            dp[n] = sum;
            if (n % 2 == 0) {
                dp[n] = dp[n] + dp[n / 2];
            }
            prefix[n] = prefix[n - 1] + dp[n];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}