import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, minResult = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> homes = new ArrayList<>(), chickens = new ArrayList<>();
	static int[][] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 1) {
					homes.add(new int[] { i, j });
				} else if (n == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}

		// chickens 에서 M 개 뽑기
		tgt = new int[M][2];
		comb(0, 0);

		System.out.println(minResult);
	}

	static void comb(int srcIdx, int tgtIdx) {
		// 조합 완성
		if (tgtIdx == M) {
			// 현재 치킨집과 집의 최소거리 계산
			int totalMin = 0;
			for (int[] h : homes) {
				int min = Integer.MAX_VALUE;
				for (int[] c : tgt) {
					int dis = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
					min = Math.min(dis, min);
				}
				totalMin += min;
			}
			minResult = Math.min(totalMin, minResult);
			return;
		}

		for (int i = srcIdx; i < chickens.size(); i++) {
			tgt[tgtIdx] = chickens.get(i);
			comb(i + 1, tgtIdx + 1);
		}
	}
}