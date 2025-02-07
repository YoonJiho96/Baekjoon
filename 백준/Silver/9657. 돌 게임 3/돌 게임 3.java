import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] dp = new boolean[1001];
        dp[1] = true;   // "SK"
        dp[2] = false;  // "CY"
        dp[3] = true;
        dp[4] = true;

        for (int i = 5; i < dp.length; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }
        System.out.println(dp[N] ? "SK" : "CY");
    }
}