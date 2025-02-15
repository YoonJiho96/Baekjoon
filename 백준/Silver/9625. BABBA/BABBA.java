import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int[][] dp = new int[46][2];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][0] = 1;

        for (int i = 3; i <= 45; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}