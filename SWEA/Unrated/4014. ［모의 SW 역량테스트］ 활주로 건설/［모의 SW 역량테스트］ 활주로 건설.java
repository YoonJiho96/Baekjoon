import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, X, ans;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 풀이
			ans = 0;

			// 가로 활주로
			for (int i = 0; i < N; i++) {
				// 필요한 변수 초기화
				int diff = 0; // 높이의 차이
				int flatCnt = 1; // 연속적으로 평평한 수, 처음 시작 좌표
				int curPos = map[i][0]; // 시작은 행 맨 앞.
				boolean isSuccess = true;

				for (int j = 1; j < N; j++) { // 가로 활주로 check
					diff = map[i][j] - curPos; // 뒤 - 앞
					if (diff == 0) { // 뒤, 앞 높이가 동일
						flatCnt++; // 연속적인 평평한 수 증가
						curPos = map[i][j]; // 이동한 높이
					} else if (diff == 1) { // up
						// x 와 지금까지의 평평했던 거리와 비교
						if (flatCnt >= X) { // 한 칸 올라가면 경사로를 설치할 수 있는지. 가능한 경우
							flatCnt = 1; // 경사로를 사용했으므로
							curPos = map[i][j];
						} else { // 경사로를 놓기에 평평한 길이가 모자란다.
							isSuccess = false;
							break;
						}
					} else if (diff == -1) { // down
						// 내려가는 상황이면 X 와 앞으로 남은 오른쪽 따진다.
						// 남은 길이가 충분한지 따진다.
						if (N - j >= X) { // 남은 길이는 충분
							// 내려온 상황
							flatCnt = 1;
							curPos = map[i][j];
							boolean isSame = true; // 가면서 모두 같지 않으면 false

							// j 다음부터 X 만큼 평평한지
							for (int k = j + 1; k < j + X; k++) {
								if (curPos != map[i][k]) {
									isSame = false;
									break;
								}
							}

							if (isSame) {
								flatCnt = 0; // 현재 위치까지 경사로를 사용했으므로
								j = j + X - 1;
							} else {
								isSuccess = false;
								break;
							}

						} else {// 경사로를 놓기에 남은 길이가 모자란다.
							isSuccess = false;
							break;
						}
					} else { // 경사로를 놓을 수 없는 상황
						isSuccess = false;
						break;
					}
				}

				if (isSuccess) { // 성공
					ans++;
				}
			}

			// 세로 활주로
			for (int i = 0; i < N; i++) { // 옆으로 가면서
				// 필요한 변수 초기화
				int diff = 0;
				int flatCnt = 1;
				int curPos = map[0][i];
				boolean isSuccess = true;

				for (int j = 1; j < N; j++) {
					diff = map[j][i] - curPos;
					if (diff == 0) {
						flatCnt++;
						curPos = map[j][i];
					} else if (diff == 1) {
						if (flatCnt >= X) {
							flatCnt = 1;
							curPos = map[j][i];
						} else {
							isSuccess = false;
							break;
						}
					} else if (diff == -1) {
						if (N - j >= X) {
							flatCnt = 1;
							curPos = map[j][i];
							boolean isSame = true;

							// j 다음부터 X 만큼 평평한지
							for (int k = j + 1; k < j + X; k++) {
								if (curPos != map[k][i]) {
									isSame = false;
									break;
								}
							}

							if (isSame) {
								flatCnt = 0;
								j = j + X - 1;
							} else {
								isSuccess = false;
								break;
							}

						} else {
							isSuccess = false;
							break;
						}
					} else { // 경사로를 놓을 수 없는 상황
						isSuccess = false;
						break;
					}
				}

				if (isSuccess) { // 성공
					ans++;
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}