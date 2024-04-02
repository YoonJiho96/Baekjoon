import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, B, S, ans;
	static int[] hList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			hList = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				hList[i] = Integer.parseInt(st.nextToken());
			}

			tgt = new int[N];
			ans = Integer.MAX_VALUE;
			dfs(0);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int[] tgt;

	static void dfs(int tgtIdx) {
		if (tgtIdx == N) {
			check();
			return;
		}

		tgt[tgtIdx] = 0;
		dfs(tgtIdx + 1);
		tgt[tgtIdx] = 1;
		dfs(tgtIdx + 1);
	}

	static void check() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (tgt[i] == 1) {
				sum += hList[i];
			}
		}
        if (sum < B)
            return;
		ans = Math.min(ans, Math.abs(B - sum));
	}
}