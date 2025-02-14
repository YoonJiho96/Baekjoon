import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        int[] from = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            from[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                from[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                from[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int cur = N; cur != 0; cur = from[cur]) {
            sb.append(cur).append(" ");
            if (cur == 1) break;
        }

        System.out.println(dp[N]);
        System.out.println(sb);
    }
}