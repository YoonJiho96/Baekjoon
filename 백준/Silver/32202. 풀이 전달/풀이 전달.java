import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            // dp[i - 1] * 2 : 현재 줄이 OX, XO 인 두 가지 경우.
            // dp[i - 2] * 2 : 현재 줄을 OO로 채우는 경우인데, 이때 i-1번째 줄은 OO가 될 수 없으므로 가능한 경우는 2가지
            dp[i] = ((dp[i - 1] * 2) + (dp[i - 2] * 2)) % MOD;
        }
        System.out.println(dp[N]);
    }
}