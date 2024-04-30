import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B, timeAns = Integer.MAX_VALUE, heightAns = 0;
	static int[][] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		input = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 최소 시간. 최대 높이
		for (int h = 0; h <= 256; h++) { // h: 목표 높이
			int blocks = B; // 블록 현황
			int getBlock = 0;
			int usedBlock = 0; // 사용한 블록

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int cur = input[i][j];
					int left = h - cur; // +:쌓아야할거, -:빼야할거

					if (left >= 0) {
						blocks -= left; // 블록 사용
						usedBlock += left;
					} else {
						blocks += -left;
						getBlock += -left; // 저장
					}

				}
			}
			if (blocks >= 0) { // 남은 블록
				int time = getBlock * 2 + usedBlock;
				if (time <= timeAns) {
					timeAns = time;
					heightAns = Math.max(heightAns, h);
				}
			}
		}
		System.out.println(timeAns + " " + heightAns);
	}
}