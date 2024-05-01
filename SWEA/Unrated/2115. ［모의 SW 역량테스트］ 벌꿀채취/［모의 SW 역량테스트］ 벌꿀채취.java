import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, C;
	static int[][] input, dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통
			M = Integer.parseInt(st.nextToken()); // 개수
			C = Integer.parseInt(st.nextToken()); // 최대양

			input = new int[N][N];
			dp = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= (N - M); j++) {
					List<Integer> temp = new ArrayList<>();
					for (int k = j; k < j + M; k++) {
						temp.add(input[i][k]);
					}

					Collections.sort(temp, (o1, o2) -> o2 - o1);
					for (int k = 0; k < temp.size(); k++) {
						int max = 0;
						int sum = 0;
						for (int l = k; l < temp.size(); l++) {
							int n = temp.get(l);
							if (n <= (C - sum)) {
								sum += n;
								max += n * n;
							}
						}
						dp[i][j] = Math.max(dp[i][j], max);
					}
				}
			}

			int result = 0;
			for (int y1 = 0; y1 < (N - 1); y1++) {
				for (int x1 = 0; x1 < (N - 1); x1++) {
					for (int y2 = y1; y2 <= (N - 1); y2++) {
						for (int x2 = 0; x2 < (N - 1); x2++) {
							if ((y1 == y2) && (x2 - x1) < M) {
								continue;
							}
							result = Math.max(result, dp[y1][x1] + dp[y2][x2]);
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}