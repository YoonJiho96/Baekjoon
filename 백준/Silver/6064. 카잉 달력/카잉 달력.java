import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, M, N, X, Y, ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			int count = 0;
			int limit = N * M / GCD(M, N);
			ans = -1;
			while (count * M < limit) {
				if ((count * M + X - Y) % N == 0) {
					ans = count * M + X;
					break;
				}
				count++;
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int GCD(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}