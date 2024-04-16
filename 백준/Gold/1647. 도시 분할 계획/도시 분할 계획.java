import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new int[] { from, to, v });
		}

		Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);
		makeSet();
		
		int result = 0;
		int count = 0;
		for (int i = 0; i < M; i++) {
			int[] e = list.get(i);

			if (union(e[0], e[1])) {
				result += e[2];
				count += 1;
			}

			if (count == N - 1) {
				result -= e[2];
				break;
			}
		}
		System.out.println(result);
	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	// a 의 부모(연결) 찾기
	static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = findSet(parent[a]);
		}
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py) {
			return false;
		}

		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
		return true;
	}
}