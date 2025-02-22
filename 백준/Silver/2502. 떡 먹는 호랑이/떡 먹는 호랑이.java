import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[D + 1][2];

        dp[1][0] = dp[2][1] = 1;
        for (int i = 3; i <= D; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        int A = 1;
        while (true) {
            for (int i = 1; i <= A; i++) {
                if (A * dp[D][1] + i * dp[D][0] == K) {
                    System.out.println(i);
                    System.out.println(A);
                    return;
                }
            }
            A++;
        }
    }
}