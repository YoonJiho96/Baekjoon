import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, ans;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			arr = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// b 로 a 들어옴
				arr[a][b] = 1;
			}

			ans = 0;
			for (int i = 1; i <= N; i++) {
				bfs(i);
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static boolean[] visit;

	static void bfs(int idx) {
		visit = new boolean[N + 1];
		visit[idx] = true;

		// 나가는 애들 확인 - 재귀
		for (int i = 1; i <= N; i++) {
			if (i == idx || arr[idx][i] == 0)
				continue;
			visit[i] = true;
			dfs(i);
		}

		// 들어가는 애들 확인 - 재귀
		for (int i = 1; i <= N; i++) {
			if (i == idx || arr[i][idx] == 0)
				continue;
			visit[i] = true;
			dfs2(i);
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i])
				count++;
		}
		if (count == N)
			ans++;
	}

	static void dfs(int idx) {
		for (int i = 1; i <= N; i++) {
			if (i == idx || arr[idx][i] == 0 || visit[i])
				continue;
			visit[i] = true;
			dfs(i);
		}
	}

	static void dfs2(int idx) {
		for (int i = 1; i <= N; i++) {
			if (i == idx || arr[i][idx] == 0 || visit[i])
				continue;
			visit[i] = true;
			dfs2(i);
		}
	}
}