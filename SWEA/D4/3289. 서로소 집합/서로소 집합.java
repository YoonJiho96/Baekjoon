import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, m;
	static int[] parent; // index : 원소, value : 부모 원소, 최상위 부모 : index == value
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// 풀이
			parent = new int[n + 1]; // 0 dummy
			makeSet();

			sb.append("#").append(t).append(" ");

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (op == 0) { // union
					union(x, y);
				} else if (op == 1) {
					if (findSet(x) == findSet(y))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet() { // 모두가 서로소인 원소 1개를 갖는 집합 배열 구조
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	// 1 -> 2 -> 3 -> 4 ... -> 999999 : 최악의 경우
	// parent[1] => 999999
	// parent[2] => 999999
	// pass compression 유리.
	// findSet() 재귀 호출이 반복적으로 호출될 때 위 구조를 계속 적용
	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
//			return findSet(parent[x]); // x 의 바로 위 부모가 최상위가 아니므로 x의 부모의 부모를 또 찾는다.
			return parent[x] = findSet(parent[x]);	// path compression
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		// 어떻게 합칠 것인가?
		// #1 앞 x 가 부모가 되도록
		parent[py] = px;
	}
}