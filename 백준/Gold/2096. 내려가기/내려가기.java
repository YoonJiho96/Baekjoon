import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
            map[i][2] = c;
        }

        int[][] dp = new int[N][3]; // 최대
        int[][] dp2 = new int[N][3];    // 최소
        dp[0][0] = dp2[0][0] = map[0][0];
        dp[0][1] = dp2[0][1] = map[0][1];
        dp[0][2] = dp2[0][2] = map[0][2];
        for (int i = 1; i < N; i++) {
            Arrays.fill(dp2[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + map[i][0];
            dp2[i][0] = Math.min(dp2[i - 1][0], dp2[i - 1][1]) + map[i][0];

            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + map[i][1];
            dp2[i][1] = Math.min(dp2[i - 1][0], Math.min(dp2[i - 1][1], dp2[i - 1][2])) + map[i][1];

            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + map[i][2];
            dp2[i][2] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + map[i][2];
        }

        int MAX = Arrays.stream(dp[N - 1]).max().getAsInt();
        int MIN = Arrays.stream(dp2[N - 1]).min().getAsInt();
        System.out.println(MAX + " " + MIN);
    }
}