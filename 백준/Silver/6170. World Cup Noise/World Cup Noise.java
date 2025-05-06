import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int MAX = 45;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[MAX + 1][2];
        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i <= MAX; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("Scenario #").append(t).append(":\n").append(dp[N - 1][0] + dp[N - 1][1]).append("\n\n");
        }

        System.out.println(sb);
    }
}