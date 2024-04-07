import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, K, N, M;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	static List<Node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				list.add(new Node(y, x, m, d));
			}

			// 이동 처리
			for (int k = 0; k < M; k++) {
				for (int i = 0; i < list.size(); i++) {
					Node n = list.get(i);
					n.y = n.y + dy[n.dir];
					n.x = n.x + dx[n.dir];

					if (n.y == 0 || n.y == N - 1 || n.x == 0 || n.x == N - 1) {
						n.changeDir();
						n.m = n.m / 2;
						if (n.m == 0) {
							list.remove(i);
							i--;
						}
					}
				}

				Collections.sort(list);

				for (int i = 0; i < list.size() - 1; i++) {
					Node n = list.get(i);
					Node nextN = list.get(i + 1);
					
					if (n.y == nextN.y && n.x == nextN.x) {
						n.m += nextN.m;
						list.remove(i + 1);
						i--;
					}
				}
			}

			// 결과 출력
			int result = 0;
			for (Node n : list) {
				result += n.m;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int y;
		int x;
		int m;
		int dir;

		public Node(int y, int x, int m, int dir) {
			this.y = y;
			this.x = x;
			this.m = m;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			int temp = this.y - o.y;
			if (temp == 0) {
				temp = this.x - o.x;
				if (temp == 0) {
					temp = o.m - this.m;
					return temp;
				}
			}
			return temp;
		}

		public void changeDir() {
			switch (this.dir) {
			case 1:
				this.dir = 2;
				break;
			case 2:
				this.dir = 1;
				break;
			case 3:
				this.dir = 4;
				break;
			case 4:
				this.dir = 3;
				break;
			}
		}
	}
}