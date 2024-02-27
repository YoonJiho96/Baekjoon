import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] cost;
	static List<List<Edge>> edgeList = new ArrayList<>();
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		cost = new int[V + 1];
		visit = new boolean[V + 1];
		for (int i = 0; i < V + 1; i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < V + 1; i++) {
			edgeList.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgeList.get(from).add(new Edge(to, cost));
		}

		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			System.out.println(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]);
		}

	}

	static void dijkstra(int v) {
		cost[v] = 0;
		pqueue.offer(new Edge(v, 0));

		while (!pqueue.isEmpty()) {
			Edge e = pqueue.poll();

			if (visit[e.to])
				continue;
			visit[e.to] = true;

			for (Edge ne : edgeList.get(e.to)) {
				if (ne.cost + cost[e.to] < cost[ne.to]) {
					cost[ne.to] = ne.cost + cost[e.to];
					ne.cost = cost[ne.to];
					pqueue.offer(ne);
				}
			}
		}
	}

	static class Edge {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}