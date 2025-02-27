import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] dp = new boolean[1001];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;

        for (int i = 4; i <= N; i++) {
            if (dp[i - 1] && dp[i - 3] && dp[i - 4]) {
                dp[i] = false;
            } else {
                dp[i] = true;
            }
        }
        System.out.println(dp[N] ? "SK" : "CY");
    }
}