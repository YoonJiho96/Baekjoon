import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] inputs = new int[2][N];
            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    inputs[i][j] = Integer.parseInt(line[j]);
                }
            }

            // dp[i][0]: i번째 열에서 선택X
            // dp[i][1]: i번째 열에서 위쪽 선택
            // dp[i][2]: i번째 열에서 아래쪽 선택
            int[][] dp = new int[N][3];

            // 초기값 설정
            dp[0][0] = 0;
            dp[0][1] = inputs[0][0];
            dp[0][2] = inputs[1][0];

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + inputs[0][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + inputs[1][i];
            }

            int result = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
            System.out.println(result);
        }
    }
}