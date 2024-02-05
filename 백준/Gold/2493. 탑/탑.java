import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<int[]> stack = new ArrayDeque<>();
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= height) {
					sb.append(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}	
			stack.push(new int[] {i, height});
		}
		System.out.println(sb);
	}
}