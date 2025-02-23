import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int sum = 1;
        int pos = 1;
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            int len = temp - pos;
            sum *= (dp[len]);
            pos = temp + 1;
        }
        System.out.println(sum * (dp[N - pos + 1]));
    }
}