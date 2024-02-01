import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N, M;
	static int[][] maps;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			maps = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					maps[i][j] = maps[i - 1][j] + maps[i][j - 1] - maps[i - 1][j - 1]
							+ Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			for (int i = M; i <= N; i ++) {
				for (int j = M; j <= N; j ++) {
					int sum = maps[i][j] - maps[i - M][j] - maps[i][j - M] + maps[i - M][j - M];
					result = Math.max(result, sum);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}