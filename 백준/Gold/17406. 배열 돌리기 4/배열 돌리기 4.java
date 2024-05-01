import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, result = Integer.MAX_VALUE;
	static int[][] input;
	static int[] tgt;
	static List<Oper> operList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			operList.add(new Oper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		tgt = new int[K];
		select = new boolean[K];
		perm(0);
		System.out.println(result);
	}

	static void score(int[][] arr) {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += arr[i][j];
			}
			result = Math.min(sum, result);
		}
	}

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) {
			temp[i] = arr[i].clone();
		}
		return temp;
	}

	static void check() {
		int[][] temp = copy(input);

		for (int t = 0; t < K; t++) {
			Oper oper = operList.get(tgt[t]);

			// 영역 돌리기
			int yTop = oper.y - oper.s;
			int yBottom = oper.y + oper.s;
			int xLeft = oper.x - oper.s;
			int xRight = oper.x + oper.s;

			int len = oper.s * 2 + 1; // 돌릴 배열 길이
			int count = len / 2 + 1; // 돌리는 횟수

			for (int i = 0; i < count; i++) {
				int[][] origin = copy(temp);

				// 위쪽
				for (int j = xLeft + 1; j <= xRight; j++) {
					temp[yTop][j] = origin[yTop][j - 1];
				}

				// 오른쪽
				for (int j = yTop + 1; j <= yBottom; j++) {
					temp[j][xRight] = origin[j - 1][xRight];
				}

				// 아래
				for (int j = xRight - 1; j >= xLeft; j--) {
					temp[yBottom][j] = origin[yBottom][j + 1];
				}

				// 왼쪽
				for (int j = yBottom - 1; j >= yTop; j--) {
					temp[j][xLeft] = origin[j + 1][xLeft];
				}

				yTop += 1;
				yBottom -= 1;
				xLeft += 1;
				xRight -= 1;
			}
		}

		// 점수 내기
		score(temp);
	}

	static boolean[] select;

	static void perm(int tgtIdx) {
		if (tgtIdx == K) {
			check();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (select[i])
				continue;
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

	static class Oper {
		int y, x, s;

		public Oper(int y, int x, int s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}
	}
}