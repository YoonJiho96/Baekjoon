import java.util.Scanner;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		tgt = new int[M];
		comb(1, 0);
		System.out.println(sb);
	}

	static int[] tgt;

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			for (int n : tgt) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = srcIdx; i <= N; i++) {
			tgt[tgtIdx] = i;
			comb(i, tgtIdx + 1);
		}
	}
}