import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// K 번 회전 후 점수 계산
// 각 회전이 독립적이므로 입력을 받으면서 바로 회전
// 시뮬레이션 과정
//     회전 정보(어떤 자석, 어떤 방향)
//     이웃 다른 자석 포함, 전체 자석의 회전 정보 미리 계산
//	   각 자석은 독립적으로 회전
//     모든 회전이 끝나면 점수 계산
// 자석의 index 0 ~ 3 (문제에서는 1 ~ 4)
public class Solution {

	static int T, K, ans;
	static int[] score = { 1, 2, 4, 8 }; // 자석별 점수
	static int[][] gear = new int[4][8];
	static int[] dir; // 각 자석별 회전 정보 (0:X, 1:시계, -1:반시계)
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());

			// 자석 + 날개
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시뮬레이션
			ans = 0;
			// K 만큼 회전 정보 입력 받으면서 바로 처리
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 움직이는 자석 id, 방향
				int id = Integer.parseInt(st.nextToken()) - 1; // 0 based
				int dir = Integer.parseInt(st.nextToken());

				// 움직이는 자석과 방향을 이용해서 다른 자석의 움직이는 정보를 미리 계산
				// dir[] 에 기록
				check(id, dir);

				// 위 dir 에 맞게 모든 자석을 회전(안하는 자석도 존재)
				rotate();
			}
			// 채점
			for (int i = 0; i < 4; i++) {
				if (gear[i][0] == 1)
					ans += score[i]; // 조건에 만족하면 점수 부여
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	// id 자석이 d 방향으로 움직일 때
	static void check(int id, int d) {
		dir = new int[4]; // 모두 0 초기화 (무회전)
		dir[id] = d;

		// id 자석의 오른쪽 자석 (이웃한 자석부터 처리)
		for (int i = id + 1; i < 4; i++) {
			if (gear[i - 1][2] != gear[i][6]) {
				dir[i] = dir[i - 1] * (-1);
			}
		}
		// id 자석의 왼쪽 자석(이웃한 자석부터 처리)
		for (int i = id - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i + 1][6]) {
				dir[i] = dir[i + 1] * (-1);
			}
		}
	}

	// 회전
	static void rotate() {
		for (int i = 0; i < 4; i++) {
			int temp;
			switch (dir[i]) {
			case 1: // 시계방향
				temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j - 1];
				}
				gear[i][0] = temp;
				break;
			case -1: // 반 시계방향
				temp = gear[i][0];
				for (int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j + 1];
				}
				gear[i][7] = temp;
				break;
			}
		}
	}
}