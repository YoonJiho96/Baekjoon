import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int MAX = 10000;
        int[] dp = new int[MAX + 1];
        dp[0] = 1;

        for (int num = 1; num <= 3; num++) {
            for (int i = num; i <= MAX; i++) {
                dp[i] += dp[i - num];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}