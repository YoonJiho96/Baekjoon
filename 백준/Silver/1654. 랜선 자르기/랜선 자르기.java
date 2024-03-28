import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Long[] input = new Long[K];
		for (int i = 0; i < K; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(input, Collections.reverseOrder());

		long left = 0;
		long right = input[0] + 1;

		while (left < right) {
			long mid = (left + right) / 2;

			// 합계 구하기
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += input[i] / mid;
			}

			if (count < N) {
				// 자른 수가 부족 => 더 작게 잘라야 함
				right = mid;
			} else {
				// 자른 수가 같거나 더 많음 =>
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
}