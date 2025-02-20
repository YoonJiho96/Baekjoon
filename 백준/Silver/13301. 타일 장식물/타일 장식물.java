import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println(4);
            return;
        }

        BigInteger[] dp = new BigInteger[N];
        dp[0] = new BigInteger("4");
        dp[1] = new BigInteger("6");
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[N - 1]);
    }
}