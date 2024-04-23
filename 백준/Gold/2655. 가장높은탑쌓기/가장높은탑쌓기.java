import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp;
	static Box[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new Box[N + 1];
		input[0] = new Box(0, 0, 0, 0);

		// 입력값 처리
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			Box box = new Box(i, width, height, weight);
			input[i] = box;
		}

		// 밑변 너비 오름차순 정렬
		Arrays.sort(input, (o1, o2) -> o1.width - o2.width);

		// 풀이
		int max = 0;
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i].weight > input[j].weight) {
					dp[i] = Math.max(dp[i], dp[j] + input[i].height); // 이전에 쌓은 블록을 올릴 수 있음
				}
			}
			max = Math.max(max, dp[i]);
		}

		// 결과 정리
		List<Integer> ans = new ArrayList<>();
		while (max > 0) {
			for (int i = N; i > 0; i--) {
				if (dp[i] == max) {
					ans.add(input[i].num);
					max -= input[i].height;
				}
			}
		}

		// 출력
		Collections.reverse(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for (int c : ans) {
			sb.append(c).append("\n");
		}
		System.out.println(sb);
	}

	static class Box {
		int num;
		int width;
		int height;
		int weight;

		public Box(int num, int width, int height, int weight) {
			this.num = num;
			this.width = width;
			this.height = height;
			this.weight = weight;
		}
	}
}