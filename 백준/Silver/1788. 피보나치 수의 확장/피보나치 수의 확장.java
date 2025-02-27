import java.util.Scanner;

public class Main {
    static final int POS = 1_000_000, MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        if (N == 0) {
            sb.append(0).append("\n").append(0);
        } else {
            int[] dp = new int[POS + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= POS; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }

            if (N < 0) {
                if (N % 2 == 0) {
                    sb.append(-1).append("\n").append(dp[Math.abs(N)]);
                } else {
                    sb.append(1).append("\n").append(dp[Math.abs(N)]);
                }
            } else {
                sb.append(1).append("\n").append(dp[N]);
            }
        }
        System.out.println(sb);
    }
}