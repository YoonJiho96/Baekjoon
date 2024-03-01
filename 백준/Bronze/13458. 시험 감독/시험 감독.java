import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, B, C;
	static long ans;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int limit = A[i];
			limit = limit - B;

			if (limit >= 0) {
				int temp = limit / C;
				int left = limit % C;

				if (left != 0) {
					temp++;
				}
				ans += (temp + 1);
			} else {
				ans++;
			}
		}
		System.out.println(ans);
	}
}