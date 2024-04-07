import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N, max;
	static int[] numbers;
	static char[] opers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		numbers = new int[N / 2 + 1];
		opers = new char[N / 2 + 1];

		int nIdx = 0;
		int oIdx = 1;
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				numbers[nIdx++] = input[i] - '0';
			} else {
				opers[oIdx++] = input[i];
			}
		}

		max = Integer.MIN_VALUE;
		tie = new boolean[opers.length];
		dfs(1);
		System.out.println(max);
	}

	static boolean[] tie;
	static int min = Integer.MAX_VALUE;

	static void dfs(int idx) {
		if (idx == opers.length) {
			check();
			return;
		}

		// 1 이상일 경우 => 이전거 체크
		if (idx > 0) {
			if (tie[idx - 1]) {
				// 이전에 묶었으면 안묶는 경우 밖에 없음
				tie[idx] = false;
				dfs(idx + 1);
			} else {
				// 이전에 안 묶었으면 안묶거나 묶거나
				tie[idx] = false;
				dfs(idx + 1);
				tie[idx] = true;
				dfs(idx + 1);
			}
		} else {
			tie[idx] = false;
			dfs(idx + 1);
			tie[idx] = true;
			dfs(idx + 1);
		}
	}

	static int operation(int n1, int n2, char cmd) {
		if (cmd == '+')
			return n1 + n2;
		else if (cmd == '-')
			return n1 - n2;
		else if (cmd == '*')
			return n1 * n2;
		return 0;
	}

	static void check() {
		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Character> operDeque = new ArrayDeque<>();

		deque.offer(numbers[0]);
		for (int i = 1; i < tie.length; i++) {
			if (tie[i]) {
				// 꺼내서 연산 후 넣기
				int num = deque.pollLast();
				int result = operation(num, numbers[i], opers[i]);
				deque.offer(result);
			} else {
				// 숫자, 연산자 넣기
				deque.offer(numbers[i]);
				operDeque.offer(opers[i]);
			}
		}

		// 최종 연산
		int num = deque.pollFirst();
		int size = deque.size();
		for (int i = 1; i < size + 1; i++) {
			int result = operation(num, deque.pollFirst(), operDeque.pollFirst());
			num = result;
		}
		max = Math.max(num, max);
	}
}