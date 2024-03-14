import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, result;
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N);
		System.out.println(result);
	}

	static boolean[] visit;

	static void bfs(int idx) {
		visit = new boolean[100001];

		visit[idx] = true;
		queue.offer(idx);

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int curIdx = queue.poll();
				if (curIdx == K) {
					result = count;
					return;
				}

				visit[curIdx] = true;
				int left = curIdx - 1;
				int right = curIdx + 1;
				int multi = curIdx * 2;

				if (left >= 0 && !visit[left]) {
					queue.offer(left);
				}
				if (right <= 100000 && !visit[right]) {
					queue.offer(right);
				}
				if (multi <= 100000 && !visit[multi]) {
					queue.offer(multi);
				}
			}
			count++;
		}
	}
}