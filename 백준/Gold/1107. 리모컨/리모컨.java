import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int tgtLen;
	static boolean[] broken;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 만들 수
		M = Integer.parseInt(br.readLine()); // 고장난 버튼의 갯수

		broken = new boolean[10];

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				int b = Integer.parseInt(st.nextToken());
				broken[b] = true;
			}
		}

		// 조건 1
		// 100일 경우
		if (N == 100) {
			System.out.println(0);
			return;
		}

		// 조건 2
		// 바로 이동
		min = Math.abs(N - 100);
		ans = min;

		// 만들 숫자 보다 한자리 더 많은 수까지 만들 수 있는 수
		// 중복 되는 조합
		int inputLen = String.valueOf(N).length();
		for (int i = 1; i <= inputLen + 1; i++) {
			tgtLen = i;
			tgt = new int[i];
			comb(0); // i 개 조합 만들기
		}

		System.out.println(ans);
	}

	static int[] tgt;
	static int min;

	static void comb(int tgtIdx) {
		if (tgtIdx == tgtLen) {
			int num = 0;
			for (int i = 0; i < tgtLen; i++) {
				num += tgt[i] * Math.pow(10, tgtLen - i - 1);
			}
			check(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (broken[i])
				continue;
			if (tgtLen > 1 && tgtIdx == 0 && i == 0) {
				continue;
			}
			tgt[tgtIdx] = i;
			comb(tgtIdx + 1);
		}
	}

	static void check(int num) {
		int gap = Math.abs(num - N);

		min = Math.min(gap, min);
		if (min == gap) {
			ans = Math.min(ans, tgtLen + gap);
		}
	}
}