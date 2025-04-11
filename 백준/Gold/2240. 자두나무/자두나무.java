import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            // 한번도 안 움직인 경우 => 이동하지 않은 경우에서 자두를 받음
            dp[i][0] = dp[i - 1][0] + (N == 1 ? 1 : 0);

            for (int j = 1; j <= W; j++) {
                // 위치 : 이동횟수 % 2 + 1 (1 or 2) 로 구해짐
                int pos = j % 2 + 1;

                // dp[i - 1][j] : 이동하지 않고, 현재 위치에 그대로
                // dp[i - 1][j - 1] : 이전에 이동해서 현재 위치로 옴 => 이동 횟수 증가
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + (N == pos ? 1 : 0);
            }
        }

        System.out.println(Arrays.stream(dp[T]).max().getAsInt());
    }
}