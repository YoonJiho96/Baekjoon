import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, score, size;
	static int[] answer, solve;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = new int[N];
		solve = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solve[i] = Integer.parseInt(st.nextToken());
			if (solve[i] == answer[i]) {
				score++;
			}
		}

		// 풀이
		dfs(0, solve);
		System.out.println(score);
	}

	static int[] push(int idx, int[] arr) {
		int[] temp = new int[N];
		for (int i = 0; i < idx; i++) {
			temp[i] = arr[i];
		}
		for (int i = idx + 1; i < N; i++) {
			temp[i] = arr[i - 1];
		}
		return temp;
	}

	static int[] pull(int idx, int[] arr) {
		int[] temp = new int[N];
		for (int i = 0; i < idx; i++) {
			temp[i] = arr[i];
		}
		for (int i = idx; i < N - 1; i++) {
			temp[i] = arr[i + 1];
		}
		return temp;
	}

	static void dfs(int idx, int[] arr) {
		if (idx == K) {
			check(arr);
			return;
		}

		for (int i = 0; i < N; i++) {
			dfs(idx + 1, push(i, arr));
			dfs(idx + 1, pull(i, arr));
			dfs(idx + 1, arr);
		}
	}

	static void check(int[] arr) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (answer[i] == arr[i]) {
				count++;
			}
		}
		score = Math.max(count, score);
	}
}