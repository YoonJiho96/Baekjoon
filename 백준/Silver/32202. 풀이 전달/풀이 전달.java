import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 0 : XO
        // 1 : OX
        // 2 : OO
        long[][] dp = new long[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            // OO 의 경우, 이번 줄에서 최소 한명이라도 불려가야 함.
            // => 이전 줄이 OO 인 경우는 제외.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
        System.out.println(Arrays.stream(dp[N]).sum() % MOD);
    }
}