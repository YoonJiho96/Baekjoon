import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][2];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        // dp[i][0] : i 번 돌 도착 (큰점프 X)
        // dp[i][1] : i 번 돌 도착 (큰점프 O)
        int[][] dp = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[1][0] = 0;
        dp[2][0] = arr[1][0];

        if (N >= 3) {
            dp[3][0] = Math.min(arr[1][1], arr[1][0] + arr[2][0]);
            dp[3][1] = INF;
        }

        for (int i = 4; i <= N; i++) {
            // 큰점프 X
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);

            // 큰 점프 했었음
            dp[i][1] = Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 2][1] + arr[i - 2][1]);
            // i - 3 에서 큰 점프로 옴
            dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + K);
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}