import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        // dp[i][n] : i 번째 수까지 썼을 때 만들 수 있는 n의 종류
        long[][] dp = new long[N + 1][21];
        dp[1][arr[1]] = 1;
        for (int i = 2; i < N; i++) {
            int num = arr[i];
            for (int j = 0; j <= 20; j++) {
                long temp = dp[i - 1][j];    // 이전까지 누적이 j 인 갯수
                if (temp == 0) continue;

                int plus = j + num;
                int minus = j - num;

                if (plus >= 0 && plus <= 20) dp[i][plus] += temp;
                if (minus >= 0 && minus <= 20) dp[i][minus] += temp;
            }
        }

        int target = arr[N];    // 목표 점수
        System.out.println(dp[N - 1][target]);
    }
}