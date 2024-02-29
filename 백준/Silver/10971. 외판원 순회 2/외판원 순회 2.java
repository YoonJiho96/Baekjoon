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

		visit = new boolean[N + 1];
		tgt = new int[N + 1]; // 0 dummy
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(min);
	}

	static boolean[] visit;
	static int[] tgt;
	static int min;

	static void perm(int tgtIdx) {
		if (tgtIdx == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				int cur = tgt[i];
				int next = tgt[i + 1];
				int go = map[cur][next];
				if (go == 0)
					return;
				sum += go;
			}
			int back = map[tgt[N]][tgt[1]];
			if (back == 0) return;
			sum += back;
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visit[i])
				continue;
			tgt[tgtIdx + 1] = i;
			visit[i] = true;
			perm(tgtIdx + 1);
			visit[i] = false;
		}
	}
}