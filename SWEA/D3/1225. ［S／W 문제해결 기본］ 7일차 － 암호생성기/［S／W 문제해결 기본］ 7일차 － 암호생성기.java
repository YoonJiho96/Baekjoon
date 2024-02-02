import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T = 10;
	static StringTokenizer st;
	static Deque<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			queue.clear();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int cnt = 0;
			while (true) {
				cnt = cnt % 5 + 1;
				int p = queue.poll() - cnt;
				p = Math.max(0, p);
				queue.add(p);
				if (p == 0)
					break;
			}
			sb.append("#").append(t).append(" ").append(queue.toString().replace("[", "").replace("]", "").replace(",", "")).append("\n");
		}
		System.out.println(sb);
	}
}
