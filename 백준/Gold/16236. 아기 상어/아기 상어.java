import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] curPos;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		curPos = new int[2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					curPos[0] = i;
					curPos[1] = j;
					map[i][j] = 0;
				}
			}
		}

		bfs();
		System.out.println(moveLen);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int moveLen, size, eat;

	static void bfs() {
		moveLen = 0;
		size = 2;
		eat = 0;

		while (true) {
			pqueue.clear();
			visit = new boolean[N][N];
			boolean valid = false;

			pqueue.offer(new Node(curPos[0], curPos[1], 0));
			visit[curPos[0]][curPos[1]] = true;

			while (!pqueue.isEmpty()) {
				Node cur = pqueue.poll();
				curPos[0] = cur.y;
				curPos[1] = cur.x;

				// 현재 노드가 물고기 일 경우
				// 먹을 수 있으면 먹기
				if (map[cur.y][cur.x] > 0 && map[cur.y][cur.x] < size) {
					map[cur.y][cur.x] = 0;
					eat += 1;
					moveLen += cur.len;
					valid = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					if (visit[ny][nx])
						continue;
					if (map[ny][nx] > size)
						continue;

					pqueue.offer(new Node(ny, nx, cur.len + 1));
					visit[ny][nx] = true;
				}
			}

			if (!valid) {
				break;
			}

			if (size == eat) {
				size++;
				eat = 0;
			}
		}
	}

	static class Node implements Comparable<Node> {
		int y, x;
		int len;

		public Node(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
		
		@Override
		public int compareTo(Node o) {
			return (this.len == o.len ? (this.y == o.y ? (this.x - o.x) : this.y - o.y) : this.len - o.len);
		}
	}
}