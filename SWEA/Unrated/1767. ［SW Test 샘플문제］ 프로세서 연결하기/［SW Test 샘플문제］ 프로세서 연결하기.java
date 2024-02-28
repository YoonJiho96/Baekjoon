import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, lenSum, coreCount;
	static StringBuilder sb = new StringBuilder();
	static int[][] input;
	static List<int[]> coreList;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			coreList = new ArrayList<>();

			N = Integer.parseInt(br.readLine());
			input = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					if (input[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							continue;
						}
						coreList.add(new int[] { i, j });
					}
				}
			}

			lenSum = Integer.MAX_VALUE;
			coreCount = 0;

			dfs(0, 0, 0);
			lenSum = lenSum == Integer.MAX_VALUE ? 0 : lenSum;
			sb.append("#").append(t).append(" ").append(lenSum).append("\n");
		}
		System.out.println(sb);
	}

	static void connect(int y, int x, int dir, int state) {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[dir];
			nx += dx[dir];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				return;
			}

			if (input[ny][nx] == 1) {
				return;
			}

			input[ny][nx] = state;
		}
	}

	static int check(int y, int x, int dir) {
		int len = 0;
		// 방향으로 진행
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[dir];
			nx += dx[dir];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				break;
			}
			if (input[ny][nx] == 1 || input[ny][nx] == 2) {
				return -1;
			}
			len++;
		}
		return len;
	}

	static void dfs(int idx, int count, int connected) {
		// 완료
		if (idx == coreList.size()) {
			if (connected == coreCount) {
				lenSum = Math.min(lenSum, count);
			} else if (connected > coreCount) {
				lenSum = count;
				coreCount = connected;
			}
			return;
		}

		int[] cur = coreList.get(idx);
		int y = cur[0];
		int x = cur[1];

		// 끝에 있으면 패스
		// 4방향 체크
		for (int i = 0; i < 4; i++) {
			int num = check(y, x, i);
			if (num >= 0) {
				connect(y, x, i, 2);
				dfs(idx + 1, count + num, connected + 1);
				connect(y, x, i, 0);
			} else {
				dfs(idx + 1, count, connected);
			}
		}
	}
}