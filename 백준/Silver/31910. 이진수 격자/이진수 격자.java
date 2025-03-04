import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = arr[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                long left = (dp[i][j - 1] << 1) + arr[i][j];
                long up = (dp[i - 1][j] << 1) + arr[i][j];
                dp[i][j] = Math.max(left, up);
            }
        }
        System.out.println(dp[N][N]);
    }
}