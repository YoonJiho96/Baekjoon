import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 기본 위치
		map[1][1] = 1;
		map[1][2] = 1;

		dfs(1, 2, 0);
		System.out.println(ans);
	}

	// 앞은 사실상 고정
	// 가야할 세군데가 모두 비어있어야 이동 가능
	// 0, 1, 2
	// 가로, 세로, 대각선 상태
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 0, 1 };
	static int ans;

	static void dfs(int y, int x, int state) {
		if (y == N && x == N) {
			// 도착
			ans++;
			return;
		}

		// 상태에 따른 방향 체크
		// 가로 -> 가로 or 대각
		if (state == 0) {
			// 1. 가로 가능 => 이동
			if (check(y, x, 0)) {
				move(y, x, 0, 1);
				dfs(y, x + 1, 0);
				move(y, x, 0, 0);
			}

			// 2. 대각 가능 => 이동
			if (check(y, x, 2)) {
				move(y, x, 2, 1);
				dfs(y + 1, x + 1, 2);
				move(y, x, 2, 0);
			}
		}
		// 세로 -> 세로 or 대각
		else if (state == 1) {
			// 1. 세로 가능 => 이동
			if (check(y, x, 1)) {
				move(y, x, 1, 1);
				dfs(y + 1, x, 1);
				move(y, x, 1, 0);
			}

			// 2. 대각 가능 => 이동
			if (check(y, x, 2)) {
				move(y, x, 2, 1);
				dfs(y + 1, x + 1, 2);
				move(y, x, 2, 0);
			}
		}
		// 대각 -> 가로 or 세로 or 대각
		else if (state == 2) {
			// 1. 가로 가능 => 이동
			if (check(y, x, 0)) {
				move(y, x, 0, 1);
				dfs(y, x + 1, 0);
				move(y, x, 0, 0);
			}

			// 2. 세로 가능 => 이동
			if (check(y, x, 1)) {
				move(y, x, 1, 1);
				dfs(y + 1, x, 1);
				move(y, x, 1, 0);
			}

			// 3. 대각 가능 => 이동
			if (check(y, x, 2)) {
				move(y, x, 2, 1);
				dfs(y + 1, x + 1, 2);
				move(y, x, 2, 0);
			}
		}
	}

	// 이동할 방향에 따른 검사
	static boolean check(int y, int x, int state) {
		if (state == 0 || state == 2) { // 가로 체크 => 오른쪽만
			int ny = y + dy[0];
			int nx = x + dx[0];
			if (ny <= 0 || ny > N || nx <= 0 || nx > N || map[ny][nx] == 1) {
				return false;
			}
		}
		if (state == 1 || state == 2) { // 세로 체크 => 아래쪽만
			int ny = y + dy[1];
			int nx = x + dx[1];
			if (ny <= 0 || ny > N || nx <= 0 || nx > N || map[ny][nx] == 1) {
				return false;
			}
		}
		if (state == 2) { // 대각 체크 => 오른쪽, 대각, 아래
			int ny = y + dy[2];
			int nx = x + dx[2];
			if (ny <= 0 || ny > N || nx <= 0 || nx > N || map[ny][nx] == 1) {
				return false;
			}
		}
		return true;
	}

	static void move(int y, int x, int state, int to) {
		if (state == 0 || state == 2) { // 가로 체크 => 오른쪽만
			int ny = y + dy[0];
			int nx = x + dx[0];
			map[ny][nx] = to;
		}
		if (state == 1 || state == 2) { // 세로 체크 => 아래쪽만
			int ny = y + dy[1];
			int nx = x + dx[1];
			map[ny][nx] = to;
		}
		if (state == 2) { // 대각 체크 => 오른쪽, 대각, 아래
			int ny = y + dy[2];
			int nx = x + dx[2];
			map[ny][nx] = to;
		}
	}
}