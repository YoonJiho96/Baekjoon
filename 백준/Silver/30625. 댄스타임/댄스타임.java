import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       // 라운드 수
        int M = Integer.parseInt(st.nextToken());       // 춤 종류

        // dp[i][2] : i 번째 춤 춘 경우, 0(이전에 틀린 적 없음), 1(이전에 틀린 적 있음)
        long[][] dp = new long[N + 1][2];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());   // 춤 종류
            int B = Integer.parseInt(st.nextToken());   // 방향

            // 다르게 춰야하는 경우
            if (B == 1) {
                // 맞게 추기 : 이전에 틀리지 않은 경우 * (M-1)가지 방법
                dp[i][0] = (dp[i - 1][0] * (M - 1)) % MOD;

                // 틀리게 추기 : (이전에 틀리지 않은 경우 * 1) + (이전에 틀린 경우 * (M-1))
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * (M - 1)) % MOD;
            }
            // 같게 추는 경우
            else {
                // 맞게 추기 : 이전에 틀리지 않은 경우 * 1가지 방법
                dp[i][0] = dp[i - 1][0] % MOD;

                // 틀리게 추기 : (이전에 틀리지 않은 경우 * (M-1)) + (이전에 틀린 경우 * 1)
                dp[i][1] = (dp[i - 1][0] * (M - 1) + dp[i - 1][1]) % MOD;
            }
        }

        System.out.println((dp[N][0] + dp[N][1]) % MOD);
    }
}