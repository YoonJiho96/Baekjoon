import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] input;
	static boolean[] team;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N + 1][N + 1];
		team = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;
		comb(1, 0);
		System.out.println(ans);
	}

	static int ans, suma, sumb;

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == N / 2) {
			check();
			return;
		}

		if (srcIdx == N + 1) {
			return;
		}

		team[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1);
		team[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx);
	}

	static void check() {
		int[] teama = new int[N / 2];
		int[] teamb = new int[N / 2];

		int a = 0;
		int b = 0;
		for (int i = 1; i <= N; i++) {
			if (team[i]) {
				teama[a++] = i;
			} else {
				teamb[b++] = i;
			}
		}

		int suma = 0;
		int sumb = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				suma += input[teama[i]][teama[j]] + input[teama[j]][teama[i]];
				sumb += input[teamb[i]][teamb[j]] + input[teamb[j]][teamb[i]];
			}
		}
		ans = Math.min(ans, Math.abs(suma - sumb));
	}
}