import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, COUNT;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] input;
	static boolean[][] visit;
	static Queue<int[]> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new char[N][N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}

		visit = new boolean[N][N];
		queue.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j]) continue;
				BFS(i, j);
			}
		}
		sb.append(COUNT).append(" ");
		COUNT = 0;
		
		visit = new boolean[N][N];
		queue.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j]) continue;
				BFS2(i, j);
			}
		}
		sb.append(COUNT);
		
		System.out.println(sb);
	}

	// 일반 구분
	static void BFS(int y, int x) {
		visit[y][x] = true;
		queue.offer(new int[] { y, x });
		char c = input[y][x];
		COUNT++;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nY = cur[0] + dy[i];
				int nX = cur[1] + dx[i];

				if (nY < 0 || nY >= N || nX < 0 || nX >= N)
					continue;
				if (visit[nY][nX])
					continue;
				if (c != input[nY][nX])
					continue;
				queue.offer(new int[] { nY, nX });
				visit[nY][nX] = true;
			}
		}
	}

	// 적록 색약
	static void BFS2(int y, int x) {
		visit[y][x] = true;
		queue.offer(new int[] { y, x });
		char c = input[y][x];
		COUNT++;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nY = cur[0] + dy[i];
				int nX = cur[1] + dx[i];

				if (nY < 0 || nY >= N || nX < 0 || nX >= N)
					continue;
				if (visit[nY][nX])
					continue;
				char nc = input[nY][nX];
				if(nc == 'R' || nc == 'G') {
					if(c == 'B') {
						continue;
					}
				}else if(nc != c) {
					continue;
				}
				
				queue.offer(new int[] { nY, nX });
				visit[nY][nX] = true;
			}
		}
	}
}