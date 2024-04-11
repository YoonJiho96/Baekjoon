import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H;
	static int[][] map;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] hdy = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] hdx = { -1, 1, -2, 2, -1, 1, -2, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
	}

	static Queue<Node> queue = new ArrayDeque<>();

	static void bfs() {
		boolean[][][] visit = new boolean[H][W][K + 1];
		Node start = new Node(0, 0, K, 0);
		queue.offer(start);
		visit[0][0][K] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.y == H - 1 && cur.x == W - 1) {
				System.out.println(cur.d);
				return;
			}

			// 4방
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][cur.k])
					continue;
				queue.offer(new Node(ny, nx, cur.k, cur.d + 1));
				visit[ny][nx][cur.k] = true;
			}

			// 8방
			if (cur.k <= 0) {
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int ny = cur.y + hdy[i];
				int nx = cur.x + hdx[i];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][cur.k - 1])
					continue;
				queue.offer(new Node(ny, nx, cur.k - 1, cur.d + 1));
				visit[ny][nx][cur.k - 1] = true;
			}
		}
		System.out.println(-1);
	}

	static class Node {
		int y, x, k, d;

		public Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}
	}
}