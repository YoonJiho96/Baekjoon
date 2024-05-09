import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, E, MAX = Integer.MAX_VALUE / 1000;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수, 도착 정점
		E = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = MAX;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[from][to] = arr[to][from] = v;
			dp[from][to] = dp[to][from] = v;
		}

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 1 -> A -> B -> N
		// 1 -> B -> A -> N
		// 각 경로 까지 최소
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
					if (i == j)
						dp[i][j] = 0;
				}
			}
		}

		int sumAB = dp[1][A] + dp[A][B] + dp[B][N];
		int sumBA = dp[1][B] + dp[B][A] + dp[A][N];
		System.out.println(Math.min(sumAB, sumBA) >= MAX ? -1 : Math.min(sumAB, sumBA));
	}
}