import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 곡 수
        int S = Integer.parseInt(st.nextToken());   // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());   // 최대 볼륨

        int[] volume = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j + volume[i] <= M) {
                        dp[i + 1][j + volume[i]] = true;
                    }

                    if (j - volume[i] >= 0) {
                        dp[i + 1][j - volume[i]] = true;
                    }
                }
            }
        }
        
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}