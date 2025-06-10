import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] dp = new int[Y + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = H;
        
        for (int i = 1; i <= Y; i++) {
            int MAX = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][0] = (int) (MAX * 1.05);

            if (i >= 3) {
                int MAX3 = Math.max(dp[i - 3][0], Math.max(dp[i - 3][1], dp[i - 3][2]));
                dp[i][1] = (int) (MAX3 * 1.2);
            }

            if (i >= 5) {
                int MAX5 = Math.max(dp[i - 5][0], Math.max(dp[i - 5][1], dp[i - 5][2]));
                dp[i][2] = (int) (MAX5 * 1.35);
            }
        }

        System.out.println(Math.max(dp[Y][0], Math.max(dp[Y][1], dp[Y][2])));
    }
}