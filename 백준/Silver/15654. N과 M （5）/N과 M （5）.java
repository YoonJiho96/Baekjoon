import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		tgt = new int[M];
		visit = new boolean[N];
		perm(0);
		System.out.println(sb);
	}

	static int[] tgt;
	static boolean[] visit;

	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			for(int n : tgt) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			tgt[tgtIdx] = nums[i];
			visit[i] = true;
			perm(tgtIdx + 1);
			visit[i] = false;
		}
	}
}