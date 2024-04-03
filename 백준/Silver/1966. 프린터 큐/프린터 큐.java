import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()); // M 번째 위치의 문서가 언제 출력되는지?

			PriorityQueue<Integer> pqueue = new PriorityQueue<>((o1, o2) -> o2 - o1); //
			Queue<Doc> queue = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				pqueue.offer(n);
				queue.offer(new Doc(i, n));
			}

			int count = 1;
			while (!queue.isEmpty()) {
				Doc n = queue.poll();
				int max = pqueue.peek();
				if (n.num == max) {
					if (n.idx == M) {
						sb.append(count).append("\n");
						break;
					}
					pqueue.poll();
					count++;
				} else {
					queue.offer(n);
				}
			}
		}
		System.out.println(sb);

	}

	static class Doc {
		int idx;
		int num;

		Doc(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
}