import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] matrix;
	static boolean[] select;
	static boolean[] visit;

	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][N + 1]; // 그래프의 인접 행렬. 0 dummy
		select = new boolean[N + 1];
		visit = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		// 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		// 인접 구역
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // i 구역에 인접한 구역의 수
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
			}
		}

		subset(1);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void check() {
		Arrays.fill(visit, false);
		queue.clear();

		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		if (queue.size() == 0) {
			return;
		}

		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && select[adj]) {
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		if (queue.size() == 0) {
			return;
		}

		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && !select[adj]) {
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i])
				return;
		}

		int sumA = 0;
		int sumB = 0;
		for (int i = 1; i <= N; i++) {
			if (select[i])
				sumA += matrix[i][0];
			else
				sumB += matrix[i][0];
		}
		min = Math.min(min, Math.abs(sumA - sumB));
	}

	static void subset(int srcIdx) {
		if (srcIdx == N + 1) {
			check();
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
}