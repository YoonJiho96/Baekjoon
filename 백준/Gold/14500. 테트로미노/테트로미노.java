import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				check(i, j, map[i][j], 0);
				visit[i][j] = false;
			}
		}

		System.out.println(max);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int[] dir = new int[3];

	static void check(int y, int x, int sum, int dep) {
		if (dep == 3) {
			max = Math.max(max, sum);
			return;
		}

		// ㅏ 처리
		// 0 : 위로 움직인 경우 => 현재 좌표 y-1, x+1/x-1
		// 1 : 아래로 움직인 경우 => 현재 좌표 y-1, x+1/x-1
		// 2 : 좌 => y+1/y-1, x+1
		// 3 : 우 => y+1/y-1, x-1
		if (dep == 2) {
			if (dir[0] == dir[1]) {
				switch (dir[0]) {
				case 0:
					if (valid(y + 1, x + 1)) {
						max = Math.max(max, sum + map[y + 1][x + 1]);
					}
					if (valid(y + 1, x - 1)) {
						max = Math.max(max, sum + map[y + 1][x - 1]);
					}
					break;
				case 1:
					if (valid(y - 1, x + 1)) {
						max = Math.max(max, sum + map[y - 1][x + 1]);
					}
					if (valid(y - 1, x - 1)) {
						max = Math.max(max, sum + map[y - 1][x - 1]);
					}
					break;
				case 2:
					if (valid(y + 1, x + 1)) {
						max = Math.max(max, sum + map[y + 1][x + 1]);
					}
					if (valid(y - 1, x + 1)) {
						max = Math.max(max, sum + map[y - 1][x + 1]);
					}
					break;
				case 3:
					if (valid(y + 1, x - 1)) {
						max = Math.max(max, sum + map[y + 1][x - 1]);
					}
					if (valid(y - 1, x - 1)) {
						max = Math.max(max, sum + map[y - 1][x - 1]);
					}
					break;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
				continue;
			dir[dep] = i;
			visit[ny][nx] = true;
			check(ny, nx, sum + map[ny][nx], dep + 1);
			visit[ny][nx] = false;
		}
	}

	static boolean valid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;
	}
}