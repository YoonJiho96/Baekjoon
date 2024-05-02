import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, W, H, count, result;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬 횟수 <= 4
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			tgt = new int[N];
			select = new boolean[W];
			result = Integer.MAX_VALUE;
			perm(0);

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int[] tgt;
	static boolean[] select;

	static void perm(int tgtIdx) {
		if (tgtIdx == N) {
			int num = check();
			result = Math.min(result, num);
			return;
		}

		for (int i = 0; i < W; i++) {
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int check() {
		int[][] copyMap = copyMap();

		Queue<int[]> queue = new ArrayDeque<>();

		// 전체 반복
		for (int i = 0; i < N; i++) {

			// 첫 부서지는 블록 찾기
			for (int j = 0; j < H; j++) {
				if (copyMap[j][tgt[i]] > 0) {
					queue.offer(new int[] { j, tgt[i] });
					break;
				}
			}

			// 부수기
			while (!queue.isEmpty()) {
				// 부술 블록 꺼내기
				// 현재 블록 부수기
				int[] cur = queue.poll();
				int num = copyMap[cur[0]][cur[1]];
				copyMap[cur[0]][cur[1]] = 0;

				// 블록 범위 탐색
				// 범위 내의 블록 큐에 추가
				for (int j = 0; j < 4; j++) {
					int ny = cur[0];
					int nx = cur[1];

					for (int k = 1; k < num; k++) {
						ny = ny + dy[j];
						nx = nx + dx[j];

						if (ny < 0 || nx < 0 || ny >= H || nx >= W)
							continue;
						if (copyMap[ny][nx] > 0) {
							queue.offer(new int[] { ny, nx });
						}
					}
				}
			}

			// 내려감
			for (int j = 0; j < W; j++) {
				Deque<Integer> stack = new ArrayDeque<>();
				for (int k = 0; k < H; k++) {
					if (copyMap[k][j] > 0) {
						stack.push(copyMap[k][j]);
						copyMap[k][j] = 0;
					}
				}

				for (int k = (H - 1); k >= 0; k--) {
					if (stack.isEmpty())
						break;
					copyMap[k][j] = stack.poll();
				}
			}
		}

		// 갯수 세기
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyMap[i][j] > 0)
					count += 1;
			}
		}
		return count;
	}

	static int[][] copyMap() {
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}
}