import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] input;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			input[i] = new int[] { t, p };
		}

		// i 날 일을 했을 때 j 날 일을 할 경우
		for (int i = 0; i < N; i++) {
			for (int j = i + input[i][0]; j <= N; j++) {
				if (dp[j] < dp[i] + input[i][1]) {
					dp[j] = dp[i] + input[i][1];
				}
			}
		}
		System.out.println(dp[N]);
	}
}