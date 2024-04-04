import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	static int T, N;
	static int[][] map;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			min = Integer.MAX_VALUE;
			map = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}

			dijstra(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int min;

	static void dijstra(int y, int x) {
		PriorityQueue<Road> pqueue = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);

		pqueue.offer(new Road(y, x, 0));
		visit[y][x] = true;

		while (!pqueue.isEmpty()) {
			Road cur = pqueue.poll();
			int cy = cur.y;
			int cx = cur.x;
			int t = cur.t;

			if (cy == N - 1 && cx == N - 1) {
				min = Math.min(min, t);
			}

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
					continue;
				}

				visit[ny][nx] = true;
				pqueue.offer(new Road(ny, nx, t + map[ny][nx]));
			}
		}
	}

	static class Road {
		int y;
		int x;
		int t;

		public Road(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}