import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] v = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = K - w[i]; j >= 0; j--) {
                dp[j + w[i]] = Math.max(dp[j + w[i]], dp[j] + v[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}