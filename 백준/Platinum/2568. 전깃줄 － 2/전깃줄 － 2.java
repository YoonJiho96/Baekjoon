import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, maxIdx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		// 없는 전기줄 -1 초기화
		int[] lines = new int[500001];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = -1;
		}

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			lines[a] = b;
			maxIdx = Math.max(a, maxIdx); // 실제 연결된 전기줄의 최대 좌표
		}

		// LIS 구하기
		int len = 0; // LIS 길이
		int[] temp = new int[500001]; // 길이 정리 배열
		int[] lisPos = new int[500001]; // 각 전기줄 별 LIS 위치 정보
		for (int i = 0; i < lines.length; i++) {
			if (lines[i] > 0) {
				int pos = Arrays.binarySearch(temp, 0, len, lines[i]);

				if (pos >= 0) {
					continue;
				}

				pos = ~pos;
				temp[pos] = lines[i];
				lisPos[i] = pos + 1;
				if (len == pos)
					len++;
			}
		}

		// 결과 정리
		int count = len;
		List<Integer> resultList = new ArrayList<>();
		for (int i = maxIdx; i >= 0; i--) {
			if (lisPos[i] == count) {
				count--;
			} else {
				if (lisPos[i] > 0) {
					resultList.add(i);
				}
			}
		}
		Collections.reverse(resultList);

		// 결과 출력
		int result = N - len; // 잘라낼 전깃줄 수
		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n");
		for (int n : resultList) {
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}
}
