import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][][] visit;
	static Train pos = null; // 출발 위치
	static Train end = null;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N][2]; // 0 : 가로일 때, 1 : 세로일 때

		// 입력
		int tCount = 0;
		int eCount = 0;
		Train[] train = new Train[3];
		Train[] endPos = new Train[3];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];

				// 출발 위치
				if (map[i][j] == 'B') {
					train[tCount] = new Train(i, j, 0);
					tCount += 1;
					if (tCount == 2) {
						// 0 가로
						// 1 세로
						if (train[0].y == train[1].y) {
							pos = new Train(train[1].y, train[1].x, 0);
						} else if (train[0].x == train[1].x) {
							pos = new Train(train[1].y, train[1].x, 1);
						}
					}
				}

				// 도착 위치
				if (map[i][j] == 'E') {
					endPos[eCount] = new Train(i, j, 0);
					eCount += 1;
					if (eCount == 2) {
						if (endPos[0].y == endPos[1].y) {
							end = new Train(endPos[1].y, endPos[1].x, 0);
						} else if (endPos[0].x == endPos[1].x) {
							end = new Train(endPos[1].y, endPos[1].x, 1);
						}
					}
				}
			}
		}

		// 이동 시작
		bfs(pos);
	}

	// 상 하 좌 우 회전
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static void bfs(Train pos) {
		Queue<Train> queue = new ArrayDeque<>();
		queue.offer(pos);
		visit[pos.y][pos.x][pos.dir] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Train cur = queue.poll();

				if (cur.y == end.y && cur.x == end.x && cur.dir == end.dir) {
					System.out.println(count);
					return;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];

					// 범위 체크
					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;

					// 나무 체크
					if (map[ny][nx] == '1')
						continue;

					// 방문 체크
					if (visit[ny][nx][cur.dir])
						continue;

					Train next = new Train(ny, nx, cur.dir);
					if (move(next)) {
						queue.offer(next);
						visit[ny][nx][cur.dir] = true;
					}
				}

				// 회전 처리
				int dir = cur.dir == 0 ? 1 : 0;
				if (!visit[cur.y][cur.x][dir]) {
					Train next = new Train(cur.y, cur.x, dir);
					if (turn(next)) {
						queue.offer(next);
						visit[cur.y][cur.x][dir] = true;
					}
				}
			}
			count += 1;
		}
		System.out.println(0);
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return false;
		return true;
	}

	// 이동 가능 체크
	static boolean move(Train pos) {
		int leftY = pos.y;
		int leftX = pos.x;
		int rightY = pos.y;
		int rightX = pos.x;

		if (pos.dir == 0) { // 가로
			leftX -= 1;
			rightX += 1;
		} else if (pos.dir == 1) { // 세로
			leftY -= 1;
			rightY += 1;
		}

		if (isValid(leftY, leftX) && isValid(rightY, rightX)) {
			if (map[leftY][leftX] == '1' || map[rightY][rightX] == '1')
				return false;
			return true;
		} else {
			return false;
		}
	}

	// 회전 가능 체크
	static boolean turn(Train pos) {
		int yTop = pos.y - 1;
		int xTop = pos.x - 1;
		int yBottom = pos.y + 1;
		int xBottom = pos.x + 1;

		// 주변에 나무 있는지 체크
		for (int i = yTop; i <= yBottom; i++) {
			for (int j = xTop; j <= xBottom; j++) {
				if(!isValid(i, j))
					return false;
				if (map[i][j] == '1')
					return false;
			}
		}
		return true;
	}

	static class Train {
		int y;
		int x;
		int dir;

		public Train(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}