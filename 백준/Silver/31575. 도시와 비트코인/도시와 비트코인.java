import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[M + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    if (dp[i - 1][j] == 1 || dp[i][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        
        System.out.println(dp[M][N] == 1 ? "Yes" : "No");
    }
}