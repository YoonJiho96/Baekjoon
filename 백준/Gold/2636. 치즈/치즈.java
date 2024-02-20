import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Y, X, total, count, time;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static List<int[]> next; // 사라질 치즈
	static int[][] map; // 전체 맵
	static boolean[][] visit;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		visit = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					total++;
				}
			}
		}

		// 0, 0 부터 탐색
		while (true) {
			// map의 1이 없어지면 종료
			if (total == 0)
				break;

			next = new ArrayList<>();
			visit = new boolean[Y][X];
			BFS(0, 0);
			for (int[] a : next) {
				map[a[0]][a[1]] = 0;
			}
		}
		System.out.println(time);
		System.out.println(count);
	}

	static void BFS(int y, int x) {
		count = 0;
		time++;
		
		queue.offer(new int[] { y, x });
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visit[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 0) {
					queue.offer(new int[] { ny, nx });
				} else {
					next.add(new int[] { ny, nx });
					count++;
				}
				visit[ny][nx] = true;
			}
		}
		total -= count;
	}
}