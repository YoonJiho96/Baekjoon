import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i][0] = T;
            arr[i][1] = P;
        }

        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            int prev = i - 1;
            int next = i + arr[i][0];
            int cost = arr[i][1];

            dp[i] = Math.max(dp[i], dp[prev]);
            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + cost);
            }
        }
        System.out.println(Math.max(dp[N], dp[N + 1]));
    }
}