import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, D, W, K, C;
	static int[][] map;
	static boolean isValid;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (K == 1) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}

			isValid = false;
			C = 0;
			for (int i = 0; i <= D; i++) {
				C = i;
				tgt = new int[C];
				tgt2 = new int[C];
				comb(0, 0);
				if (isValid) {
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(C).append("\n");
		}
		System.out.println(sb);
	}

	static int[] tgt; // 어느 행에 뿌릴지
	static int[] tgt2; // tgt[n] 행에 어떤 약을 뿌릴지

	static void comb(int srcIdx, int tgtIdx) {
		if (isValid)
			return;
		if (tgtIdx == C) {
			check(0, 0);
			return;
		}

		for (int i = srcIdx; i < D; i++) {
			tgt[tgtIdx] = i;
			comb(i + 1, tgtIdx + 1);
		}
	}

	static void check(int srcIdx, int tgtIdx) {
		if (isValid)
			return;
		if (tgtIdx == C) {
			// 뿌려서 확인
			test();
			return;
		}

		tgt2[tgtIdx] = 0;
		check(srcIdx + 1, tgtIdx + 1);
		tgt2[tgtIdx] = 1;
		check(srcIdx + 1, tgtIdx + 1);
	}

	static void test() {
		int[][] copy = copy();
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < W; j++) {
				copy[tgt[i]][j] = tgt2[i];
			}
		}

		// 세로 검사
		boolean valid = true;
		for (int i = 0; i < W; i++) { // 가로
			int cur = copy[0][i];
			int count = 1;
			int max = 0;
			for (int j = 1; j < D; j++) {
				if (copy[j][i] == cur) {
					count++;
					max = Math.max(max, count);
				} else {
					count = 1;
					cur = copy[j][i];
				}
			}
			if (max < K) {
				valid = false;
				break;
			}
		}
		if (valid) {
			isValid = true;
		}
	}

	static int[][] copy() {
		int[][] temp = new int[D][W];
		for (int i = 0; i < D; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}
}