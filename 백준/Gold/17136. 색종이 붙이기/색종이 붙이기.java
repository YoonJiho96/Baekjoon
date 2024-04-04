import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] used;
	static boolean[][] visit;
	static List<int[]> oList = new ArrayList<>();
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		visit = new boolean[10][10];
		used = new int[6];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] *= -1;
					oList.add(new int[] { i, j });
				}
			}
		}

		result = Integer.MAX_VALUE;
		if (oList.size() == 0) {
			result = 0;
		} else {
			dfs(0, 0, 0);
		}
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	// count : 판에 붙은 종이 숫자
	static void dfs(int count, int idx, int dep) {
		if (idx == oList.size()) {
			if (count == oList.size()) {
				result = Math.min(result, dep);
			}
			return;
		}

		int[] cur = oList.get(idx);
		int y = cur[0];
		int x = cur[1];

		if (!visit[y][x]) {
			// 현재 위치에 색종이 놓기
			// 크기 1 ~ 크기 5 모두 가능한 경우 확인
			for (int i = 1; i <= 5; i++) {
				// 5번 다 씀
				if (used[i] >= 5) {
					continue;
				}
				// 현재 위치에 크기 i 의 색종이를 놓음.
				if (valid(y, x, i)) {
					attach(y, x, i, i);
					used[i] += 1;

					dfs(count + i * i, idx + 1, dep + 1);

					attach(y, x, i, -1);
					used[i] -= 1;
				}
			}
		} else {
			dfs(count, idx + 1, dep);
		}
	}

	static void attach(int y, int x, int m, int state) {
		for (int i = y; i < y + m; i++) {
			for (int j = x; j < x + m; j++) {
				map[i][j] = state;
				if (state > 0)
					visit[i][j] = true;
				else
					visit[i][j] = false;
			}
		}
	}

	// m 크기 색종이 가능여부
	static boolean valid(int y, int x, int m) {
		for (int i = y; i < y + m; i++) {
			for (int j = x; j < x + m; j++) {
				// 유효
				if (i >= 10 || j >= 10 || map[i][j] == 0 || visit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}