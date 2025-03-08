import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final int SIZE = 250;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BigInteger[] dp = new BigInteger[SIZE + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        // dp[i] = dp[i-1] + 2*dp[i-2]
        // (이전 방법에서 1x2 => 하나) + (2개 전에서 2x2 나 2x1 두개 => 두가지)
        for (int i = 2; i <= SIZE; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}