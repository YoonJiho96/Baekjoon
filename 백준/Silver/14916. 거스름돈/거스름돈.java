import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            int A = dp[i - 2];
            int B = dp[i - 5];

            // 둘 다 -1 인 경우 => 만들 수 없는 수
            if (A == -1 && B == -1) {
                dp[i] = -1;
            } else {
                // 둘 중 하나는 -1 이 아닌 경우 => 만들 수 있음
                if (A == -1) {
                    dp[i] = B + 1;
                } else if (B == -1) {
                    dp[i] = A + 1;
                } else {
                    dp[i] = Math.min(A + 1, B + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}