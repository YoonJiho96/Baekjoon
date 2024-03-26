import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, mSum;
	static int[] mList, cList;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mList = new int[N + 1];
		cList = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			mList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cList[i] = Integer.parseInt(st.nextToken());
			mSum += cList[i];
		}

		dp = new int[N + 1][mSum + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= mSum; j++) {
				if (j - cList[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cList[i]] + mList[i]);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}

		for (int i = 0; i <= mSum; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}