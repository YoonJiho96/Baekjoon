import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static int[][] map;

	// dfs
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// graph
	static int V; // 정점의 수
	// 간선 자료구조
	static List<Edge> edges = new ArrayList<>();

	static class Edge {
		int v1, v2, c;

		Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}

	// 서로소
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		// 섬, 바다 입력 <= 섬은 -1로 변경
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) * (-1); // 1-> -1, 0 -> 0
			}
		}

		// 풀이 #1 dfs <= V(정점) 번호로 구분하기
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1 && !visit[i][j]) { // 새로운 섬(정점)
					dfs(i, j, num);
					num++;
				}
			}
		}

		// 정점 수
		V = num - 1; // 마지막 dfs() 이후 num++ 보정

		// 서로소 자료구조
		parent = new int[V + 1]; // 0 dummy
		makeSet();

		// 간선 리스트 완성 - 가로로, 세로로
		hr();
		vr();

		// 쿠르스칼
		// 간선을 최소비용으로 정렬, 사이클이 생기지 않은 조건으로 선택해가면서 간선의 수가 V-1 가 종료
		Collections.sort(edges, (e1, e2) -> e1.c - e2.c);
		int cnt = 0; // 선택된 간선의 수
		int size = edges.size();
		for (int i = 0; i < size; i++) {
			Edge e = edges.get(i);
			if (union(e.v1, e.v2)) {
				// 간선 선택
				min += e.c;
				cnt++;
			}
			if (cnt == V - 1)
				break; // 완성
		}

		if (cnt != V - 1 || min == 0)
			min = -1;
		System.out.println(min);
	}

	static void addEdge(int v1, int v2, int cost) {
		boolean same = false;
		for (Edge edge : edges) {
			if (edge.v1 == v1 && edge.v2 == v2) {
				same = true;
				edge.c = Math.min(edge.c, cost); // 같은 정점을 연결하는 간선이면 비용 최소화
				break;
			}
		}

		if (!same)
			edges.add(new Edge(v1, v2, cost));
	}

	static void hr() {
		for (int i = 0; i < N; i++) { // 밑으로 움직이면서
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;

			for (int j = 0; j < M; j++) { // 옆으로 움직이면서
				curr = map[i][j];
				if (prev == 0 && curr != 0) { // 0(바다, 시작 경계선) -> 0아님(섬)
					if (v1 == 0) { // 시작 경계선 -> 섬
						v1 = curr; // 시적섬 번호
					} else { // 이미 시작한 섬이 있고 0 거쳐서 섬도착
						// edge 발생
						v2 = curr;
						if (cost > 1) {
							addEdge(v1, v2, cost);
//                            addEdge(v2, v1, cost); 쿠르스칼 생략
						}
						// 도착섬이 시작섬으로 관련 초기화
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if (v1 != 0 && curr == 0) { // 섬에서 시작해서 현재 바다
					// 비용 발생
					cost++;
				}

				prev = curr;
			}
		}
	}

	static void vr() {
		for (int i = 0; i < M; i++) { // 옆으로 움직이면서
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;

			for (int j = 0; j < N; j++) { // 밑으로 움직이면서
				curr = map[j][i];
				if (prev == 0 && curr != 0) { // 0(바다, 시작 경계선) -> 0아님(섬)
					if (v1 == 0) { // 시작 경계선 -> 섬
						v1 = curr; // 시적섬 번호
					} else { // 이미 시작한 섬이 있고 0 거쳐서 섬도착
						// edge 발생
						v2 = curr;
						if (cost > 1) {
							addEdge(v1, v2, cost);
//                            addEdge(v2, v1, cost); 쿠르스칼 생략
						}
						// 도착섬이 시작섬으로 관련 초기화
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if (v1 != 0 && curr == 0) { // 섬에서 시작해서 현재 바다
					// 비용 발생
					cost++;
				}

				prev = curr;
			}
		}
	}

	static void dfs(int y, int x, int num) {
		visit[y][x] = true;
		map[y][x] = num;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
				continue;
			if (map[ny][nx] == -1)
				dfs(ny, nx, num);
		}
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py)
			return false; // 사이클 생긴다. // x,y를 연결하는 간선 선택불가
		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;
		return true; // x,y를 연결하는 간선 선택 가능
	}
}