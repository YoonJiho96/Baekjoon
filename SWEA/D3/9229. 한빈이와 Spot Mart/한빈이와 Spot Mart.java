import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] sList, resultList;
	static int result;
	static int N, M;
	static int COUNT = 2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			sList = new int[N];
			resultList = new int[COUNT];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sList[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			comb(0, 0);
			sb.append("#").append(t).append(" ").append((result == 0) ? -1 : result).append("\n");
		}
		System.out.println(sb);

	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == COUNT) {
			int sum = Arrays.stream(resultList).sum();
			if (sum <= M) {
				result = Math.max(sum, result);
			}
			return;
		}
		for (int i = srcIdx; i < N; i++) {
			resultList[tgtIdx] = sList[i];
			comb(i + 1, tgtIdx + 1);
		}
	}
}
