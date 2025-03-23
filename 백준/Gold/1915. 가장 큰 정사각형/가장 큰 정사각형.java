import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = input[j - 1] - '0';
                dp[i][j] = arr[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0) continue;

                int lt = dp[i - 1][j - 1];
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                int min = Math.min(lt, Math.min(left, top));

                if (min == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = min + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }
}