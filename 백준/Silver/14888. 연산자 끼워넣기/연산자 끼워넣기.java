import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, min, max, input[], oper[];
	// 연산자 0:+, 1:-, 2:X, 3:/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		oper = new int[4];
		ans = new int[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		dfs(0, input[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static int[] ans;

	static void dfs(int idx, int temp) {
		if (idx == N - 1) {
			min = Math.min(min, ans[N - 2]);
			max = Math.max(max, ans[N - 2]);
			return;
		}

		if (oper[0] != 0) {
			int result = operation(temp, input[idx + 1], 0);
			ans[idx] = result;
			oper[0]--;
			dfs(idx + 1, result);
			oper[0]++;
		}
		if (oper[1] != 0) {
			int result = operation(temp, input[idx + 1], 1);
			ans[idx] = result;
			oper[1]--;
			dfs(idx + 1, result);
			oper[1]++;
		}
		if (oper[2] != 0) {
			int result = operation(temp, input[idx + 1], 2);
			ans[idx] = result;
			oper[2]--;
			dfs(idx + 1, result);
			oper[2]++;
		}
		if (oper[3] != 0) {
			int result = operation(temp, input[idx + 1], 3);
			ans[idx] = result;
			oper[3]--;
			dfs(idx + 1, result);
			oper[3]++;
		}
	}

	static int operation(int n1, int n2, int op) {
		switch (op) {
		case 0: {
			return n1 + n2;
		}
		case 1: {
			return n1 - n2;
		}
		case 2: {
			return n1 * n2;
		}
		case 3: {
			return n1 / n2;
		}
		}
		return 0;
	}
}