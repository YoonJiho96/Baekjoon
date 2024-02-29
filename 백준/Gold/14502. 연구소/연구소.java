import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max, wallCount;
	static final int WALL = 3;
	static int[][] map;
	static List<int[]> vList = new ArrayList<>(); // 바이러스 좌표
	static List<int[]> bList = new ArrayList<>(); // 빈칸 좌표
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					vList.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					bList.add(new int[] { i, j });
				} else {
					wallCount++;
				}
			}
		}

		for (int i = 0; i < WALL; i++) {
			tgt.add(new int[] {});
		}

		comb(0, 0);
		System.out.println(max);
	}

	static List<int[]> tgt = new ArrayList<>();

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == WALL) {
			// 현재 벽 조합에서 DFS 시작
			doWall(1);
			virusCount = 0;
			visit = new boolean[N][M];
			for (int[] c : vList) {
				visit[c[0]][c[1]] = true;
				dfs(c[0], c[1]);
			}
			int safe = bList.size() - 3 - virusCount;
			max = Math.max(safe, max);
			doWall(0);
			return;
		}

		for (int i = srcIdx; i < bList.size(); i++) {
			tgt.set(tgtIdx, bList.get(i));
			comb(i + 1, tgtIdx + 1);
		}
	}

	static boolean[][] visit;
	static int virusCount;

	static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}
			if (map[ny][nx] != 0) {
				continue;
			}
			visit[ny][nx] = true;
			virusCount++;
			dfs(ny, nx);
		}
	}

	static void doWall(int num) {
		for (int[] p : tgt) {
			map[p[0]][p[1]] = num;
		}
	}
}