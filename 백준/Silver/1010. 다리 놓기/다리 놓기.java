import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(comb(m, n));
		}
	}

	static int[][] dp = new int[30][30];

	static int comb(int n, int m) {
		if (dp[n][m] > 0) {
			return dp[n][m];
		}
		if (n == m || m == 0) {
			return dp[n][m] = 1;
		}
		return dp[n][m] = comb(n - 1, m - 1) + comb(n - 1, m);
	}
}