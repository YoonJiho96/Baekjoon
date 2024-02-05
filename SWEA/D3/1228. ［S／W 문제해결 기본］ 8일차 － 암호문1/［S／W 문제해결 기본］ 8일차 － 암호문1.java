import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T = 10;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 1. 개수
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			// 2. 기본 입력 초기화
			Deque<Integer> deque = new ArrayDeque<>();
			for (int j = 0; j < N; j++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			// 3. 명령어
			st = new StringTokenizer(br.readLine());
			int cmdNum = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			// 명령 개수만큼 반복
			for (int j = 0; j < cmdNum; j++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken()); // 삽입할 인덱스
				int cntNum = Integer.parseInt(st.nextToken()); // 개수

				Deque<Integer> temp = new ArrayDeque<>();
				// 개수 만큼 먼저 넣고,
				for (int k = 0; k < idx; k++) {
					temp.offer(deque.poll());
				}

				// 추가 항목 넣기
				for (int k = 0; k < cntNum; k++) {
					temp.offer(Integer.parseInt(st.nextToken()));
				}

				// 원래 항목 다시 넣기
				while (!deque.isEmpty()) {
					temp.offer(deque.poll());
				}
				deque = temp;
			}
			
			sb.append("#").append(i).append(" ");
			for(int j=0; j<10; j++) {
				sb.append(deque.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}