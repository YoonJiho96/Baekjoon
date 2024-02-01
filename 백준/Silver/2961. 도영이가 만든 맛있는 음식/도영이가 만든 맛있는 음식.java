import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] src;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		src = new int[N][2];

		// 초기값
		min = Integer.MAX_VALUE; // 가장 큰 값

		// 배열 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);
		System.out.println(min);
	}

	static void subset(int srcIdx, int mask) {
		if (srcIdx == N) {
			// 현재 select 에 선택된 재료가 true 설정
			// 선택된 재료의 신맛합, 쓴맛합을 구한 다음 그 차이의 최소값 갱신
			// 단 재료가 1개 이상
			int sin = 1; // 곱
			int ssn = 0; // 합
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if ((mask & 1 << i) != 0) {
					cnt++;
					sin *= src[i][0];
					ssn += src[i][1];
				}
			}
			if (cnt > 0) {
				min = Math.min(min, Math.abs(sin - ssn));
			}
			return;
		}

		subset(srcIdx + 1, mask | 1 << srcIdx);
		subset(srcIdx + 1, mask);
	}
}