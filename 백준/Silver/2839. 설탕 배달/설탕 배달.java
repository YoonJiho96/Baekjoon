import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N; // 배달할 킬로그램.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] maps = new int[5001];

		maps[3] = 1;
		maps[4] = 0;
		maps[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (maps[i - 5] != 0) {
				maps[i] = maps[i - 5] + 1;
			}
			if (maps[i - 3] != 0) {
				if (maps[i] != 0) {
					maps[i] = Math.min(maps[i], maps[i - 3] + 1);
				} else {
					maps[i] = maps[i - 3] + 1;
				}
			}
		}
		System.out.println(maps[N] == 0 ? -1 : maps[N]);
	}
}
