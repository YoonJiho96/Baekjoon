import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// subset + binary counting
public class Solution {

	static int T, N, L, max;
	static Item[] src;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N 개의 재료
			L = Integer.parseInt(st.nextToken());

			src = new Item[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			max = 0;
			int subsetCnt = 1 << N;

			for(int i=0; i<subsetCnt; i++) {
				int cal = 0;
				int point = 0;

				for(int j=0; j<N; j++) {
					if((i & 1 << j) == 0 ) continue;
					cal += src[j].c;
					point += src[j].p;
				}
				if(cal <= L) max = Math.max(max, point);
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static class Item {
		int p, c;

		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
}