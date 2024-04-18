import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, input[];
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int len = 0;

		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(dp, 0, len, input[i]);

			if (pos >= 0)
				continue;
			pos = ~pos;
			dp[pos] = input[i];
			if (len == pos)
				len++;
		}
		System.out.println(len);
	}
}