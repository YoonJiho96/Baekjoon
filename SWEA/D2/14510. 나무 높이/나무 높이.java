import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];

			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				if (max < input[i])
					max = input[i];
			}

			List<Integer> left = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				input[i] = max - input[i];
				if (input[i] != 0) {
					left.add(input[i]);
				}
			}

			int twoCount = 0; // 2로 나눈 수 = 2만큼 물을줄 수
			int oneCount = 0; // 1남은 수
			for (int i = 0; i < left.size(); i++) {
				twoCount += left.get(i) / 2;
				oneCount += left.get(i) % 2;
			}

			int result = 0;
			// 1-2 짝 맞추기
			if (oneCount <= twoCount) {
				twoCount -= oneCount;
				result += oneCount * 2; // 1-2 짝 맞춤

				// 남은 2 처리 필요 => 1-2 쌍으로 나누기
				int leftCount = twoCount * 2;
				result += (leftCount / 3) * 2;
				result += leftCount % 3;
			} else { // 1이 더 많음
				oneCount -= twoCount;
				result += twoCount * 2;

				// 남은 1 처리. 1은 무조건 1로만 가능
				int leftCount = oneCount;
				result += leftCount * 2 - 1;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}