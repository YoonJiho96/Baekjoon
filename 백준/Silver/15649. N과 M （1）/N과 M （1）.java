import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] tgt;		// src 배열 유지할 필요 없이. 그냥 인덱스 값으로 활용.
	static boolean[] select;
	static StringBuilder sb;	// StringBuilder 출력 변경
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		select = new boolean[N + 1];
		tgt = new int[M];

		perm(0);
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		// 기저 조건
		if (tgtIdx == M) {
			// Complete Code. 완성시 작성할 코드
			for (int n : tgt) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
}