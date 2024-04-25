import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dist;
	static int N, M;
	static final int MAX = 10000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = map[n2][n1] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					dist[i][j] = 1;
				} else {
					dist[i][j] = MAX;
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int min = MAX;
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (dist[i][j] != MAX) {
					count += dist[i][j];
				}
			}
			if (count < min) {
				min = count;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}