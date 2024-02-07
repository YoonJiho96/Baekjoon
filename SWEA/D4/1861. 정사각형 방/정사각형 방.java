import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// visit 배열이 필요한가? => 필요 없음
// * 항상 나보다 값을 탐색하기 때문.
// delta for 문 break; 추가.
public class Solution {
	static int[][] map;
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
					dfs(i, j, map[i][j], 1);
				}
			}

			sb.append("#").append(t).append(" ").append(NO).append(" ").append(COUNT).append("\n");
		}
		System.out.println(sb);
	}

	// y, x 좌표, no : 시작번호, cnt : 방문 횟수
	static void dfs(int y, int x, int no, int cnt) {
		// 기저 조건 X

		// 문제 처리
		if (cnt > COUNT) {
			COUNT = cnt;
			NO = no;
		} else if (cnt == COUNT) {
			NO = (no < NO) ? no:NO;
		}
		
		// 이후 조건에 맞는 더 갈 수 있는 곳 방문
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != map[y][x] + 1) {
				continue;
			}
			dfs(ny, nx, no, cnt+1);
			break;
		}
	}
}