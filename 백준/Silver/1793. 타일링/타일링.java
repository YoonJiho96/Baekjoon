import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static final int SIZE = 250;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[SIZE + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        // dp[i] = dp[i-1] + 2*dp[i-2]
        // (이전 방법에서 1x2 => 하나) + (2개 전에서 2x2 나 2x1 두개 => 두가지)
        for (int i = 2; i <= SIZE; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        String input = null;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}