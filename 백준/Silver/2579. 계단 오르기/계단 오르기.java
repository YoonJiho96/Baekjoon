import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];

		for (int i = 0; i < N; i++) {
			input[i][0] = Integer.parseInt(br.readLine());
		}

		if (N == 1) {
			System.out.println(input[0][0]);
			return;
		}

		input[1][1] = input[0][0] + input[1][0];

		for (int i = 2; i < N; i++) {
			input[i][1] = input[i - 1][0] + input[i][0];
			input[i][0] = Math.max(input[i - 2][0], input[i - 2][1]) + input[i][0];
		}
		System.out.println(Math.max(input[N - 1][0], input[N - 1][1]));
	}
}