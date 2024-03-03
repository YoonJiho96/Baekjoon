import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, K;
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dice = new int[7];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());

			int ny = y + dy[cmd];
			int nx = x + dx[cmd];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				continue;
			}
			y = ny;
			x = nx;
			int[] temp = dice.clone();
			switch (cmd) {
			case 1:
				dice[1] = temp[4];
				dice[3] = temp[1];
				dice[6] = temp[3];
				dice[4] = temp[6];
				break;
			case 2:
				dice[1] = temp[3];
				dice[3] = temp[6];
				dice[4] = temp[1];
				dice[6] = temp[4];
				break;
			case 3:
				dice[1] = temp[5];
				dice[2] = temp[1];
				dice[5] = temp[6];
				dice[6] = temp[2];
				break;
			case 4:
				dice[1] = temp[2];
				dice[2] = temp[6];
				dice[5] = temp[1];
				dice[6] = temp[5];
				break;
			}
			if (map[ny][nx] == 0) {
				map[ny][nx] = dice[6];
			} else {
				dice[6] = map[ny][nx];
				map[ny][nx] = 0;
			}
			sb.append(dice[1]).append("\n");
		}
		System.out.println(sb);
	}
}