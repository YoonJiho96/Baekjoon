import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        int row, col;
        row = col = 1;

        String input;
        while (row <= N) {
            input = br.readLine();
            if (input.equals("")) continue;
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int n : nums) {
                map[row][col++] = n;
                if (col > N) {
                    col = 1;
                    row++;
                }
            }
        }

        int[][] dp = new int[N + 1][N + 1];

        dp[1][1] = map[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }

        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        int sum = dp[i][j] - dp[k - 1][j] - dp[i][l - 1] + dp[k - 1][l - 1];
                        MAX = Math.max(MAX, sum);
                    }
                }

            }
        }

        System.out.println(MAX);
    }
}