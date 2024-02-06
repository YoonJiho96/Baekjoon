import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T = 10; // 테스트 케이스 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int cnt = Integer.parseInt(st.nextToken());

			String[] tree = new String[401]; // 1 부터 시작
			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				String idx = st.nextToken();
				String op = st.nextToken();

				// 트리 삽입
				tree[Integer.parseInt(idx)] = op;
			}

			// 정점 노드부터 체크
			Deque<Integer> queue = new ArrayDeque<>();
			int cur;
			boolean result = false;
			queue.offer(1);
			while(!queue.isEmpty()) {
				cur = queue.poll();
				// 좌 우 노드 체크
				int left = cur * 2;
				int right = cur * 2 + 1;
				
				// 자식 노드가 있을 경우
				if(tree[left] != null && tree[right] != null) {
					queue.offer(left);
					queue.offer(right);
					// 현재 노드가 숫자일 경우 정답 X
					if(Character.isDigit((tree[cur]).charAt(0))) {
						result = false;
						break;
					}
				}
				// 자식 노드가 없는 경우
				else {
					// 연산자로 끝나면 정답 X
					if(!Character.isDigit((tree[cur]).charAt(0))) {
						result = false;
						break;
					}
				}
			}
			
			if(queue.isEmpty()) {
				result = true;
			}
			
			sb.append("#").append(t).append(" ").append(result? 1:0).append("\n");
		}
		System.out.println(sb);
	}
}