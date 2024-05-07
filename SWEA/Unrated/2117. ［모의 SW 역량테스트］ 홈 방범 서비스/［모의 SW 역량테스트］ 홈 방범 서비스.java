import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, ans;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][N];

		int K = 1;
		int house = 0;

		queue.offer(new int[] { y, x });
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();

				int cury = cur[0];
				int curx = cur[1];
				if (map[cury][curx] == 1) {
					house++;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cury + dy[i];
					int nx = curx + dx[i];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
						continue;
					}
					if (visit[ny][nx])
						continue;
					queue.offer(new int[] { ny, nx });
					visit[ny][nx] = true;
				}
			}

			int cost = K * K + (K - 1) * (K - 1);
			int value = house * M;
			if (cost <= value) {
				ans = Math.max(ans, house);
			}
			K++;
		}
	}
}