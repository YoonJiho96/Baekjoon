import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);

            if (i - a > 0) {
                dp[i] = Math.min(dp[i - a - 1] + 1, dp[i]);
            }
            if (i - b > 0) {
                dp[i] = Math.min(dp[i - b - 1] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}