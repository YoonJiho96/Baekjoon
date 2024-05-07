import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp[j - 1] - '0';
			}
		}

		bfs(1, 1);
	}

	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { y, x });
		visit = new boolean[N + 1][M + 1];

		int count = 0;
		boolean end = false;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();
				int cy = cur[0];
				int cx = cur[1];

				if (cy == N && cx == M) {
					end = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cy + dy[i];
					int nx = cx + dx[i];

					if (ny <= 0 || nx <= 0 || ny > N || nx > M)
						continue;
					if (visit[ny][nx])
						continue;
					if (map[ny][nx] == 0)
						continue;
					queue.offer(new int[] { ny, nx });
					visit[ny][nx] = true;
				}
			}
			count += 1;
			if (end)
				break;
		}
		System.out.println(count);
	}
}