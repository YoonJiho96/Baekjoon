import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H, leftTomato = 0;
	static int[][][] map;
	static List<int[]> tomato = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		map = new int[H][N][M];
		visit = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						tomato.add(new int[] { i, j, k });
					}
					if (map[i][j][k] == 0)
						leftTomato += 1;
				}
			}
		}

		if (leftTomato == 0) {
			System.out.println(0);
			return;
		}

		queue = new ArrayDeque<>();
		for (int i = 0; i < tomato.size(); i++) {
			int[] cur = tomato.get(i);
			visit[cur[0]][cur[1]][cur[2]] = true;
			queue.add(cur);
		}
		int day = bfs();

		if (leftTomato > sum) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}

	static boolean[][][] visit;
	static Queue<int[]> queue;

	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int sum = 0; // 전염된 토마토 수

	static int bfs() {
		int day = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			day += 1;

			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();

				if (map[cur[0]][cur[1]][cur[2]] == 0)
					sum += 1;

				// 4방
				for (int i = 0; i < 6; i++) {
					int ny = cur[1] + dy[i];
					int nx = cur[2] + dx[i];
					int nz = cur[0] + dz[i];

					if (ny < 0 || nx < 0 || ny >= N || nx >= M || nz < 0 || nz >= H)
						continue;
					if (visit[nz][ny][nx])
						continue;
					if (map[nz][ny][nx] == -1)
						continue;
					queue.offer(new int[] { nz, ny, nx });
					visit[nz][ny][nx] = true;
				}
			}
		}
		return day - 1;
	}
}