import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				int left = j - 1;
				int right = j;

				int leftSum = 0;
				int rightSum = 0;
				if (left >= 0) {
					leftSum = dp[i - 1][left] + dp[i][j];
				}
				if (right < i) {
					rightSum = dp[i - 1][right] + dp[i][j];
				}
				dp[i][j] = Math.max(leftSum, rightSum);
			}
		}
		Arrays.sort(dp[N - 1]);
		System.out.println(dp[N - 1][N - 1]);
	}
}