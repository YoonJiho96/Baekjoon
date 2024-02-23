import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static double E;
	static double result;
	static List<Edge> input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			// X 좌표
			input = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				input.add(new Edge(num));
			}
			// Y 좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				input.get(i).y = num;
			}

			E = Double.parseDouble(br.readLine());

			// 풀이
			// 2개씩 조합
			tgt = new int[2];
			edges = new ArrayList<>();
			comb(0, 0);
			// 거리 순 정렬
			Collections.sort(edges, (o1, o2) ->{
				return Double.compare(o1[2], o2[2]);
			} );

			// kruskal
			parent = new int[N];
			int cnt = 0;
			result = 0;
			makeSet();
			for (int i = 0; i < edges.size(); i++) {
				double[] e = edges.get(i);
				int v1 = (int) e[0];
				int v2 = (int) e[1];

				if (union(v1, v2)) {
					result = result + E * Math.pow(e[2], 2);
					cnt++;
				}
				if (cnt == N - 1)
					break;
			}
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

	static int[] parent;

	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = findSet(parent[x]);
		}
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (py == px) {
			return false;
		}
		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
		return true;
	}

	static int[] tgt; // 조합 결과 : [간선번호1, 간선번호2]
	static List<double[]> edges; // [간선번호1, 간선번호2, 길이]

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 2) {
			double dis = getDis(tgt[0], tgt[1]);
			edges.add(new double[] { tgt[0], tgt[1], dis });
			return;
		}

		for (int i = srcIdx; i < input.size(); i++) {
			tgt[tgtIdx] = i;
			comb(i + 1, tgtIdx + 1);
		}
	}

	static double getDis(int a, int b) {
		Edge ae = input.get(a);
		Edge be = input.get(b);
		return Math.sqrt(Math.pow(ae.x - be.x, 2) + Math.pow(ae.y - be.y, 2));
	}

	static class Edge {
		int x, y;

		Edge(int x) {
			this.x = x;
		}
	}
}