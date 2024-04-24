import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] home = new int[15][15];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 14; i++) {
			home[0][i] = i;
		}

		for (int i = 1; i <= 14; i++) {
			int temp = 0;
			for (int j = 1; j <= 14; j++) {
				temp += home[i - 1][j];
				home[i][j] = temp;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(home[k][n]).append("\n");
		}
		System.out.println(sb);
	}
}