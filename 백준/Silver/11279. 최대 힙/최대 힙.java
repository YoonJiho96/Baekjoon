import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			if (X == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			} else {
				pq.offer(X);
			}
		}
		System.out.println(sb);
	}
}