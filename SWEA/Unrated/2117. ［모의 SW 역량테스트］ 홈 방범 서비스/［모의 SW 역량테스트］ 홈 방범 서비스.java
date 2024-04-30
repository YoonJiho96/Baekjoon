import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, mLimit;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			mLimit = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						mLimit += M; // 최대 지불 가능한 금액
					}
				}
			}

			int result = 0;

			// 모든 좌표. K = 1부터 시작. => 비용이 33 초과면 OUT
			int K = 1;
			int value = K * K + (K - 1) * (K - 1); // 유지 비용
			while (value <= mLimit) {
				// K 크기일 때
				// 모든 좌표 검사 => (0, 0) 울 중심으로 검사
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int num = checkBound(i, j, K); // 범위 내의 집 수
						if (num * M >= value) {
							result = Math.max(result, num);
						}
					}
				}

				K += 1;
				value = K * K + (K - 1) * (K - 1);
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	// (y, x) 기준. 길이 K 영역
	// 포함되는 집 수 반환
	static int checkBound(int y, int x, int k) {
		int sum = 0;
		k -= 1;
		for (int i = (y - k); i <= (y + k); i++) {
			for (int j = (x - k); j <= (x + k); j++) {
				if (!isValid(i, j))
					continue;
				if (getDis(y, x, i, j) > k)
					continue;
				if (map[i][j] == 1) {
					sum += 1;
				}
			}
		}
		return sum;
	}

	static int getDis(int y, int x, int y1, int x1) {
		return (Math.abs(y1 - y) + Math.abs(x1 - x));
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return false;
		return true;
	}
}