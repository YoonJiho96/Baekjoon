import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0 : 증가, 1 : 감소
        int[][] dp = new int[N][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        int MAX = 1;

        for (int i = 1; i < N; i++) {
            int cur = arr[i];
            if (cur >= arr[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }

            if (cur <= arr[i - 1]) {
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][1] = 1;
            }

            MAX = Math.max(MAX, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(MAX);
    }
}