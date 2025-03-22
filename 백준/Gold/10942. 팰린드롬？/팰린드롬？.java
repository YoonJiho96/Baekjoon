import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] : i ~ j 팰린드롬인지 여부
        boolean[][] dp = new boolean[N][N];

        // 길이가 1인 경우 : 항상 팰린드롬
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // 길이가 3 이상인 경우 (길이 len 인 구간)
        for (int len = 3; len <= N; len++) {
            for (int start = 0; start <= N - len; start++) {
                int end = start + len - 1;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s - 1][e - 1] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}