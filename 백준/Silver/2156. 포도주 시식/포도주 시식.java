import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0 : 연속 안먹음, 1 : 연속 1잔, 2 : 연속 2잔
        int[][] dp = new int[n + 1][3];
        int[] wine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
        }
        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}