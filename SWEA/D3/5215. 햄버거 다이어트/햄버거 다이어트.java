import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, L, max;
	static int[][] src;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			src = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i][0] = (Integer.parseInt(st.nextToken()));
				src[i][1] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int srcIdx, int point, int cal) {
		if (srcIdx == N) {
			max = Math.max(max, point);
			return;
		}

		dfs(srcIdx + 1, point, cal);
		int nextCal = cal + src[srcIdx][1];
		if(nextCal <= L) {
			dfs(srcIdx + 1, point + src[srcIdx][0], nextCal);
		}
	}
}
