import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// binary count
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

		// Binary Count 풀이
		int subsetCnt = 1 << src.length;	// 조합 수
		
		// 0 제외 : 재료 없는 경우
		for (int i = 1; i < subsetCnt; i++) {	// 재료 최소 한개 이상.
			// 이미 i 가 완성된 부분집합.
			int sin = 1; // 곱
			int ssn = 0; // 합
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {	// mask -> i 대체 가능.
					sin *= src[j][0];
					ssn += src[j][1];
				}
			}
			min = Math.min(min, Math.abs(sin - ssn));		// 0인 경우 없음
		}
		
		System.out.println(min);
	}
}