import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 입력 처리
		List<Planet> input = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input.add(new Planet(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		// 좌표 별 정렬
		List<Planet> xSorted = new ArrayList<>(input);
		List<Planet> ySorted = new ArrayList<>(input);
		List<Planet> zSorted = new ArrayList<>(input);
		Collections.sort(xSorted, (o1, o2) -> o1.x - o2.x);
		Collections.sort(ySorted, (o1, o2) -> o1.y - o2.y);
		Collections.sort(zSorted, (o1, o2) -> o1.z - o2.z);

		// 길이 별 정렬
		for (int i = 0; i < N - 1; i++) {
			pq.offer(new Edge(xSorted.get(i).num, xSorted.get(i + 1).num,
					Math.abs(xSorted.get(i).x - xSorted.get(i + 1).x)));
			pq.offer(new Edge(ySorted.get(i).num, ySorted.get(i + 1).num,
					Math.abs(ySorted.get(i).y - ySorted.get(i + 1).y)));
			pq.offer(new Edge(zSorted.get(i).num, zSorted.get(i + 1).num,
					Math.abs(zSorted.get(i).z - zSorted.get(i + 1).z)));
		}

		int ans = 0;
		int count = 0;
		// 짧은 간선부터 계산
		parent = new int[N];
		makeSet();
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				ans += getValue(input.get(cur.a), input.get(cur.b));
				count += 1;
			}
			if (count >= N - 1)
				break;
		}
		System.out.println(ans);
	}

	static int getValue(Planet a, Planet b) {
		return Math.min(Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)), Math.abs(a.z - b.z));
	}

	static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);

	static int[] parent;

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py) {
			return false;
		}

		if (px > py) {
			parent[px] = parent[py];
		} else {
			parent[py] = parent[px];
		}
		return true;
	}

	static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = findSet(parent[x]);
		}
	}

	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	static class Planet {
		int num, x, y, z;

		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge {
		int a, b, v;

		public Edge(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}
	}
}