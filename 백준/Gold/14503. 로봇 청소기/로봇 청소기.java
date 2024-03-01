import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, r, c, d, ans;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean();
		System.out.println(ans);
	}

	// 방향 : 0:북, 1:동, 2:남, 3:서 <= 시계방향
	// 반시계 => 0 -> 3 -> 2 -> 1 -> 0...
	static void clean() {
		while (true) {
			// 현재 칸 확인 후 청소
			if (map[r][c] != 2) {
				map[r][c] = 2;
				ans++;
			}

			boolean valid = false;
			// d 방향부터 -> 나머지 순으로
			int[] temp = new int[4];
			for (int i = 0; i < 4; i++) {
				temp[i] = (d + 3 - i) % 4;
			}
			for (int i = 0; i < 4; i++) {
				int dir = temp[i];

				int ny = r + dy[dir];
				int nx = c + dx[dir];

				if (ny > N || nx > M || ny < 0 || nx < 0)
					continue;
				// 빈칸 있음
				if (map[ny][nx] == 0) {
					d = dir; // 방향 변경
					r = ny;
					c = nx;
					valid = true;
					break;
				}
			}
			if (!valid) {
				r = r - dy[d];
				c = c - dx[d];

				if (r > N || c > M || r < 0 || c < 0 || map[r][c] == 1) {
					break;
				}
			}
		}
	}
}