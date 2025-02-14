import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = 71;
        int[][][] dp = new int[size][size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (i <= 50 || j <= 50 || k <= 50) {
                        dp[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k]
                                + dp[i - 1][j - 1][k]
                                + dp[i - 1][j][k - 1]
                                - dp[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            int result;
            if (a <= 0 || b <= 0 || c <= 0) {
                result = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                result = dp[70][70][70];
            } else {
                result = dp[a + 50][b + 50][c + 50];
            }

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }
        System.out.print(sb);
    }
}