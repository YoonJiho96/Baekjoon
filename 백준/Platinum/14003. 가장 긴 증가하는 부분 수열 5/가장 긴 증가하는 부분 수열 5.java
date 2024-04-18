import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, input[];
	static int[] dp, memoi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		dp = new int[N];
		memoi = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int len = 0;

		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(dp, 0, len, input[i]);

			if (pos >= 0) {
				memoi[i] = pos;
				continue;
			}
			pos = ~pos;
			dp[pos] = input[i];
			memoi[i] = pos;
			if (len == pos)
				len++;
		}
		StringBuilder sb = new StringBuilder();

		int temp = len - 1;
		int[] result = new int[len];
		for (int i = N - 1; i >= 0; i--) {
			if (memoi[i] == temp) {
				result[temp--] = input[i];
			}
		}
		
		for(int i=0; i<len; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		System.out.println(len);
		System.out.println(sb);
	}
}