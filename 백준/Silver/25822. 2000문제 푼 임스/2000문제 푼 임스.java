import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double C = Double.parseDouble(br.readLine());
        int COUNT = Math.min((int) (C / 0.99), 2);

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int MAX = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            MAX = Math.max(MAX, input[i]);
        }

        // dp[i][COUNT] :
        // dp[i][0] => i를 풀었을 때, 스트릭 안 쓰고 최대 길이
        // dp[i][1] => i를 풀었을 때, 스트릭 한번 쓰고 최대 길이
        int[][] dp = new int[N][COUNT + 1];

        int cur = input[0];

        // 초기값 설정
        if (cur == 0) {
            for (int j = 1; j <= COUNT; j++) {
                dp[0][j] = 1;
            }
        } else {
            Arrays.fill(dp[0], 1);
        }

        int STRIC = 1;
        for (int i = 1; i < N; i++) {
            cur = input[i];

            // 스트릭 깨거나 프리즈 사용
            if (cur == 0) {
                // 프리즈 사용
                for (int j = 1; j <= COUNT; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 스트릭 새로 시작
                dp[i][0] = 0;
            }
            // 문제 풀어서 스트릭 이어감
            else {
                for (int j = 0; j <= COUNT; j++) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }

            // 최대 길이 구하기
            for (int j = 0; j <= COUNT; j++) {
                STRIC = Math.max(STRIC, dp[i][j]);
            }
        }

        System.out.println(STRIC);
        System.out.println(MAX);
    }
}