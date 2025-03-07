import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX = 64;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // dp[i][n] : i자리 수 중, n으로 끝나는 줄지 않는 수
        long[][] dp = new long[MAX + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= MAX; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(Arrays.stream(dp[n]).sum()).append("\n");
        }
        System.out.println(sb);
    }
}