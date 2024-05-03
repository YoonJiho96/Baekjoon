import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<Pos> hList = new ArrayList<>();
	static List<Pos> cList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					hList.add(new Pos(i, j));
				if (map[i][j] == 2)
					cList.add(new Pos(i, j));
			}
		}

		// M 크기 조합
		tgt = new int[M];
		comb(0, 0);
		System.out.println(ans);
	}

	static int getDis(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	static int check() {
		int sum = 0;
		for (int i = 0; i < hList.size(); i++) {
			int len = Integer.MAX_VALUE;
			for (int j = 0; j < tgt.length; j++) {
				len = Math.min(len, getDis(hList.get(i), cList.get(tgt[j])));
			}
			sum += len;
		}
		return sum;
	}

	static int[] tgt;

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			ans = Math.min(ans, check());
			return;
		}

		for (int i = srcIdx; i < cList.size(); i++) {
			tgt[tgtIdx] = i;
			comb(i + 1, tgtIdx + 1);
		}
	}

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}