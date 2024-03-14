import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T, M, N, K;
	static int[][] map;
	static List<int[]> bc;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			bc = new ArrayList<>();
			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
				bc.add(new int[] { y, x });
			}

			int count = 0;
			for (int i = 0; i < K; i++) {
				int[] cur = bc.get(i);
				if (!visit[cur[0]][cur[1]]) {
					visit[cur[0]][cur[1]] = true;
					dfs(cur[0], cur[1]);
					count++;
				}
			}
			System.out.println(count);
		}
	}

	static boolean[][] visit;

	static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}
			if (map[ny][nx] == 1) {
				visit[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}
}