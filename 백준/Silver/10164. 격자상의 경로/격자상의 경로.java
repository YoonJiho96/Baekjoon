import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N][M];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if (K == 0) {
            System.out.println(dp[N - 1][M - 1]);
        } else {
            int y = (K / M) + 1;
            int x = K - ((y - 1) * M);
            int y2 = N - y + 1;
            int x2 = M - x + 1;
            System.out.println(dp[y - 1][x - 1] * dp[y2 - 1][x2 - 1]);
        }
    }
}