import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[][] memoi;
	static int T, N, NO, COUNT; // 방번호, 이동횟수
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];	
			memoi = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 풀이
			NO = 0;
			COUNT = 1;

			// 모든 좌표에서 다 시도. 그 각각의 결과 중 최선을 선택
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = dfs(i, j);
					int no = map[i][j];

					// 문제 처리
					if (cnt > COUNT) {
						COUNT = cnt;
						NO = no;
					} else if (cnt == COUNT) {
						NO = (no < NO) ? no:NO;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(NO).append(" ").append(COUNT).append("\n");
		}
		System.out.println(sb);
	}
	static int dfs(int y, int x) {
		if(memoi[y][x] != 0) {
			return memoi[y][x];
		}
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == map[y][x] + 1) {
				return memoi[y][x] = dfs(ny, nx) + 1;
			}
		}
		return memoi[y][x] = 1;
	}
}