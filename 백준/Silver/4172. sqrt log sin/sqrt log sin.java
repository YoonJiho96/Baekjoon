import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[1_000_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int I = Integer.parseInt(br.readLine());
            if (I == -1) break;
            sb.append(dfs(I)).append("\n");
        }
        System.out.println(sb);
    }

    static long dfs(int i) {
        if (i == 0) {
            return 1;
        }

        if (dp[i] == 0) {
            int term1 = (int) (i - Math.sqrt(i));
            int term2 = (int) Math.log(i);
            int term3 = (int) (i * Math.pow(Math.sin(i), 2));

            dp[i] = (dfs(term1) + dfs(term2) + dfs(term3)) % 1000000;
        }
        return dp[i];
    }
}