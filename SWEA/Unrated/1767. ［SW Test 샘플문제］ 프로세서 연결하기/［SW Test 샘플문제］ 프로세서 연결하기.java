import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, count, result;
	static int[][] map;
	static List<int[]> coreList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			coreList = new ArrayList<>();
			resultMap = new HashMap<>();
			count = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == (N - 1) || j == (N - 1))
							continue;
						coreList.add(new int[] { i, j });
					}
				}
			}

			dfs(0, 0, 0);
			int max = Collections.max(resultMap.keySet());
			result = resultMap.get(max);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Map<Integer, Integer> resultMap;

	static void dfs(int idx, int len, int c) {
		if (idx == coreList.size()) {
			if (resultMap.containsKey(c)) {
				int min = Math.min(len, resultMap.get(c));
				resultMap.put(c, min);
			} else {
				resultMap.put(c, len);
			}
			return;
		}

		int[] core = coreList.get(idx);

		for (int i = 0; i < 4; i++) {
			if (canConnect(core[0], core[1], i)) {
				int l = connect(core[0], core[1], i, -1);
				dfs(idx + 1, len + l, c + 1);
				connect(core[0], core[1], i, 0);
			}
		}
		dfs(idx + 1, len, c);
	}

	static boolean canConnect(int y, int x, int dir) {
		int ny = y;
		int nx = x;

		while (true) {
			ny = ny + dy[dir];
			nx = nx + dx[dir];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				return true;
			}
			if (map[ny][nx] != 0) {
				return false;
			}
		}
	}

	static int connect(int y, int x, int dir, int state) {
		int len = 0;
		int ny = y;
		int nx = x;

		while (true) {
			ny = ny + dy[dir];
			nx = nx + dx[dir];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				break;
			}
			map[ny][nx] = state;
			len += 1;
		}
		return len;
	}
}