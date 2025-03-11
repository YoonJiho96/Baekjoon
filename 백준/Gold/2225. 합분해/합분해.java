import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 0 ~ N 까지 정수
        int K = Integer.parseInt(st.nextToken());   // K 개 더해서 N이 되게


        // dp[i][j] : 정수 i를 j개의 수로 만드는 경우
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;       // 0은 무조건 1개 경우
        }
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;       // 각 정수 하나만 1개 경우
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // dp[i][j - 1] : 한개 적은 갯수로 i 만드는 경우에 0을 붙임
                // dp[i - 1][j] : i - 1 작은 수를 만드는 경우에 1을 붙임
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }
        System.out.println(dp[N][K]);
    }
}