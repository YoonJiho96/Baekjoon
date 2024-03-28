import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, dPos[];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map;
	static List<int[]> wList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		wList = new ArrayList<>();
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String cur = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = cur.charAt(j);
				map[i][j] = c;
				if (c == '*') {
					wList.add(new int[] { i, j });
				}
				if (c == 'S') {
					dPos = new int[] { i, j };
				}
			}
		}

		bfs();
	}

	static boolean[][] visit;

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int[] n : wList) {
			queue.offer(n);
		}

		Queue<int[]> dQueue = new ArrayDeque<>();
		dQueue.offer(dPos);

		int count = 0;
		while (!queue.isEmpty() || !dQueue.isEmpty()) {
			int size = queue.size();

			count++;

			// 고슴
			int dSize = dQueue.size();
			for (int i = 0; i < dSize; i++) {
				int[] cur = dQueue.poll();

				if (map[cur[0]][cur[1]] == '*')
					continue;

				for (int j = 0; j < 4; j++) {
					int ny = cur[0] + dy[j];
					int nx = cur[1] + dx[j];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						continue;
					if (map[ny][nx] == 'D') {
						System.out.println(count);
						return;
					}
					if (map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						dQueue.offer(new int[] { ny, nx });
					}
				}
			}

			// 물 이동 체크
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();

				for (int j = 0; j < 4; j++) {
					int ny = cur[0] + dy[j];
					int nx = cur[1] + dx[j];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						continue;

					if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
						map[ny][nx] = '*';
						queue.offer(new int[] { ny, nx });
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}