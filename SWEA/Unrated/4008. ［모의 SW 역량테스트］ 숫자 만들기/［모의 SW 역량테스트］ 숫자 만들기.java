import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, max, min;
	static int[] input, oper;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			oper = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			// 연산자 순서 조합
			tgt = new int[N - 1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(t).append(" ").append(Math.abs(max - min)).append("\n");
		}
		System.out.println(sb);
	}

	static int[] tgt;

	static void perm(int tgtIdx) {
		if (tgtIdx == N - 1) {
			check();
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] == 0)
				continue;
			tgt[tgtIdx] = i;
			oper[i]--;
			perm(tgtIdx + 1);
			oper[i]++;
		}
	}

	static void check() {
		int cur = input[0];

		for (int i = 1; i < N; i++) {
			int op = tgt[i - 1];
			// 0:+, 1:-, 2:*, 3:/
			switch (op) {
			case 0:
				cur += input[i];
				break;
			case 1:
				cur -= input[i];
				break;
			case 2:
				cur *= input[i];
				break;
			case 3:
				cur /= input[i];
				break;
			}
		}
		max = Math.max(max, cur);
		min = Math.min(min, cur);
	}
}