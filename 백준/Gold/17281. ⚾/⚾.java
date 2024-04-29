import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input = new int[N][9 + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm = new int[9 + 1];
		select = new boolean[9 + 1];

		perm[4] = 1;
		select[4] = true;

		max = 0;
		perm(2);
		System.out.println(max);
	}

	// 순서 구하기
	static int[] perm; // i번째 선수의 순서
	static boolean[] select;

	static void perm(int tgt) {
		if (tgt == 10) {
			check();
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (select[i])
				continue;
			perm[i] = tgt;
			select[i] = true;
			perm(tgt + 1);
			select[i] = false;
		}
	}

	static int max;

	// 각 순서 별 점수 구하기
	static void check() {
		int idx = 1;
		int[] base = new int[4]; // 1루 2루 3루 홈

		int score = 0;
		for (int e = 0; e < N; e++) {
			int out = 0;
			while (true) {
				idx = idx / 10 + (idx % 10);
				int hit = input[e][perm[idx]];

				if (hit == 0) {
					out += 1;
				} else if (hit >= 1) {
					base[0] = 1;
					for (int i = 0; i < hit; i++) {
						if (base[3] == 1)
							score += 1;
						for (int j = 3; j > 0; j--) {
							base[j] = base[j - 1];
							base[j - 1] = 0;
						}
					}
				}
				idx += 1;

				if (out >= 3) {
					Arrays.fill(base, 0);
					break;
				}
			}
		}
		max = Math.max(max, score);
	}
}