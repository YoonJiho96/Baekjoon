import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] jump = new int[N];
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N];
        Arrays.fill(dp, 1000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int j = jump[i];
            for (int k = 1; k <= j; k++) {
                int next = i + k;

                if (next >= N) break;
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        System.out.println(dp[N - 1] == 1000 ? -1 : dp[N - 1]);
    }
}