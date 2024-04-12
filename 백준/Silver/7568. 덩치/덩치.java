import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] += 1;
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if (input[i][0] > input[j][0] && input[i][1] > input[j][1]) {
					result[j] += 1;
				} else if (input[j][0] > input[i][0] && input[j][1] > input[i][1]) {
					result[i] += 1;
				}
			}
		}
		for (int n : result) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}