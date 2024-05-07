import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] move;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		move = new int[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			move[a] = b;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			move[a] = b;
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 1, 0 });

		boolean[] visit = new boolean[101];

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();

				if (cur[0] == 100) {
					return cur[1];
				}

				if (move[cur[0]] != 0) {
					cur[0] = move[cur[0]];
				}

				for (int i = 1; i <= 6; i++) {
					if (cur[0] + i <= 100) {
						if (visit[cur[0] + i])
							continue;
						queue.offer(new int[] { cur[0] + i, cur[1] + 1 });
						visit[cur[0] + i] = true;
					}
				}
			}
		}
		return -1;
	}

	static class Move {
		int from;
		int to;

		Move(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}