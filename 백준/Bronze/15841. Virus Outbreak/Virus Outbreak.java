import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[491];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i < 491; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) break;
            sb.append("Hour ").append(N).append(": ").append(dp[N]).append(" cow(s) affected\n");
        }
        System.out.println(sb);
    }
}