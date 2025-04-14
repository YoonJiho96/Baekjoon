import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] : 1 -> i 까지 드는 최대 힘 중 최소
        long[] dp = new long[N + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // j -> i 경우
            for (int j = 1; j < i; j++) {
                long power = (long) (i - j) * (1 + Math.abs(arr[j] - arr[i]));
                dp[i] = Math.min(dp[i], Math.max(dp[j], power));
            }
        }
        System.out.println(dp[N]);
    }
}