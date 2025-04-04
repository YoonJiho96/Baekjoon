import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][2] : i 까지 누적합 중 최대값
        // 0 : 이전에 제거한 적 없음, 1: 이전에 값 제거한 적 있음
        int[][] dp = new int[N + 1][2];
        dp[1][0] = arr[1];
        dp[1][1] = 0;       // 첫번째 제거한 경우
        MAX = arr[1];

        for (int i = 2; i <= N; i++) {
            // 이전에 제거하지 않은 값, 현재도 제외하지 않고 최대값
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);

            // 이전에 제거한 적 있거나, 현재 제거
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);

            MAX = Math.max(MAX, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(MAX);
    }
}