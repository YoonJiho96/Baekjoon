import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 구간 개수
        int K = Integer.parseInt(st.nextToken());   // 이동 방식 바꾸는 비용

        int[][] arr = new int[N + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[i][2] : i 위치일 때 0(끌고 갈 때), 1(들고 갈 때) 최소 비용
        long[][] dp = new long[N + 1][2];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= N; i++) {
            // 이어서 끌고 가기 or 들다가 끌기
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i][0], dp[i - 1][1] + arr[i][0] + K);

            // 이어서 들고 가기 or 끌고 가다 들기
            dp[i][1] = Math.min(dp[i - 1][1] + arr[i][1], dp[i - 1][0] + arr[i][1] + K);
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}