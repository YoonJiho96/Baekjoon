import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = 1;
		}

		K = Integer.parseInt(br.readLine());
		Deque<Oper> queue = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char oper = st.nextToken().toCharArray()[0];

			queue.offer(new Oper(t, oper));
		}

		int turn = 0;
		int dir = 3; // right

		int y = 1;
		int x = 1;
		boolean end = false;
		
		Deque<int[]> snake = new ArrayDeque<>();
		snake.addFirst(new int[] { y, x });
		while (true) {
			// 이동
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			// 벽 체크
			if (ny <= 0 || nx <= 0 || ny > N || nx > N) {
				break;
			}

			// 몸 체크
			for (int[] s : snake) {
				if (ny == s[0] && nx == s[1]) {
					end = true;
					break;
				}
			}
			if (end)
				break;

			// 사과 체크
			if (map[ny][nx] == 1) {
				// 사과 먹고 꼬리 줄이지 않음
				map[ny][nx] = 0;
			} else {
				// 꼬리 줄임
				snake.pollLast();
			}

			// 이동
			y = ny;
			x = nx;
			turn += 1;
			snake.addFirst(new int[] { ny, nx });

			// 다음 동작 여부 체크
			if (queue.isEmpty()) {
				continue;
			}
			if (queue.peekFirst().t != turn) {
				continue;
			}

			// 동작 변경
			Oper cur = queue.poll();

			// 방향 전환
			// 0 => L:2, R:3
			// 1 => L:3, R:2
			// 2 => L:1, R:0
			// 3 => L:0, R:1
			if (cur.oper == 'L') {
				if (dir == 0)
					dir = 2;
				else if (dir == 1)
					dir = 3;
				else if (dir == 2)
					dir = 1;
				else if (dir == 3)
					dir = 0;
			} else {
				if (dir == 0)
					dir = 3;
				else if (dir == 1)
					dir = 2;
				else if (dir == 2)
					dir = 0;
				else if (dir == 3)
					dir = 1;
			}
		}
		System.out.println(turn + 1);
	}

	static class Oper {
		int t;
		char oper;

		Oper(int t, char oper) {
			this.t = t;
			this.oper = oper;
		}
	}
}