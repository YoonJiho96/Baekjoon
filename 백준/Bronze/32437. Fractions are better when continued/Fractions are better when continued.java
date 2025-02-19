import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N * 2];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < (N * 2); i += 2) {
            dp[i] = dp[i - 1];
            dp[i + 1] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N * 2 - 2]);
    }
}