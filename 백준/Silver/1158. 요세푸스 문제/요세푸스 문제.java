import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (!queue.isEmpty()) {
			for(int i=1; i<K; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if(!queue.isEmpty())	sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}