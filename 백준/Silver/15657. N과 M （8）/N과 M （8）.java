import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] src, tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		src = new int[N];
		tgt = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);

		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			for(int i=0; i<M; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = srcIdx; i < N; i++) {
			tgt[tgtIdx] = src[i];
			comb(i, tgtIdx + 1);
		}
	}
}