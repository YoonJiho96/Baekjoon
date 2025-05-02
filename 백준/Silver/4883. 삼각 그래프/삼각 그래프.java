import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int IDX = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][3];
            dp[0][0] = 1_000_000;
            dp[0][1] = map[0][1];
            dp[0][2] = map[0][1] + map[0][2];
            for (int i = 1; i < N; i++) {
                Arrays.fill(dp[i], 1_000_000);
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    // 위에서 온 경우
                    for (int k = (j - 1); k <= (j + 1); k++) {
                        if (k >= 0 && k < 3) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + map[i][j]);
                        }
                    }

                    // 왼쪽에서 온 경우
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + map[i][j]);
                    }
                }
            }
            sb.append(IDX++).append(". ").append(dp[N - 1][1]).append("\n");
        }

        System.out.println(sb);
    }
}