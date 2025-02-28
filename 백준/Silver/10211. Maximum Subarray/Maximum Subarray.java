import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N + 1];
            int[] dp = new int[N + 1];  // i 까지의 누적합
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    dp[i] = arr[i];
                } else {
                    dp[i] = dp[i - 1] + arr[i];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                max = Math.max(max, dp[i]);
                for (int j = 1; j < i; j++) {
                    int num = dp[i] - dp[j];
                    max = Math.max(max, num);
                }
            }
            System.out.println(max);
        }
    }
}