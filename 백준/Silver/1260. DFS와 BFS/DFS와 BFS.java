import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] tree;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		tree = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from][to] = tree[to][from] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int cur) {
		sb.append(cur).append(" ");
		visit[cur] = true;
		
		for(int i=1; i<=N; i++) {
			if(tree[cur][i] == 0) continue;
			if(visit[i]) continue;
			
			visit[i] = true;
			dfs(i);
		}
	}

	static void bfs(int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(start);
		Arrays.fill(visit, false);
		visit[start] = true;
		
		while(!deque.isEmpty()) {
			int cur = deque.poll();
			sb.append(cur).append(" ");
			
			for(int i=1; i<=N; i++) {
				if(i == cur) continue;
				if(visit[i]) continue;
				if(tree[cur][i] == 1) {
					deque.offer(i);
					visit[i] = true;
				}
			}
		}
		sb.append("\n");
	}
}