import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static final int LEN = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] dp = new BigInteger[LEN + 1];
        dp[1] = dp[2] = BigInteger.ONE;
        for (int i = 3; i <= LEN; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(dp[P].mod(BigInteger.valueOf(Q))).append("\n");
        }
        System.out.println(sb);
    }
}