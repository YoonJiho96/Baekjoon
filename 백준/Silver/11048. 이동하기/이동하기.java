import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[M];
        dp[0] = arr[0][0];
        for (int j = 1; j < M; j++) {
            dp[j] = dp[j - 1] + arr[0][j];
        }

        for (int i = 1; i < N; i++) {
            int prev = dp[0];
            dp[0] = dp[0] + arr[i][0];
            for (int j = 1; j < M; j++) {
                int temp = dp[j];
                dp[j] = Math.max(Math.max(dp[j], dp[j - 1]), prev) + arr[i][j];
                prev = temp;
            }
        }
        System.out.println(dp[M - 1]);
    }
}