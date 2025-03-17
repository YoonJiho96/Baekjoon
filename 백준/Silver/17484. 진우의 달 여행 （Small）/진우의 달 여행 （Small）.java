import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int INF = 100000000;
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = map[0][j];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int prevCol = 0; prevCol < M; prevCol++) {
                for (int prevDir = 0; prevDir < 3; prevDir++) {
                    for (int dir = 0; dir < 3; dir++) {
                        if (prevDir == dir) continue;
                        int newCol = prevCol + (dir - 1);
                        if (newCol < 0 || newCol >= M) continue;
                        dp[i][newCol][dir] = Math.min(dp[i][newCol][dir], dp[i - 1][prevCol][prevDir] + map[i][newCol]);
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[N - 1][i][j]);
            }
        }
        System.out.println(ans);
    }
}