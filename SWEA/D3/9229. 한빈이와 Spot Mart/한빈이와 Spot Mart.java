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
			Arrays.sort(sList);

			result = 0;
			for(int i=(N-1); i>0; i--) {
				for(int j=(i-1); j>=0; j--) {
					int sum = sList[i] + sList[j];
					if(sum <= M) {
						result = Math.max(result, sum);
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append((result == 0) ? -1 : result).append("\n");
		}
		System.out.println(sb);
	}
}
