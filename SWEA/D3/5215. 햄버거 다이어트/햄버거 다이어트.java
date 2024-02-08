import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, L, max;
	static Item[] src;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N 개의 재료
			L = Integer.parseInt(st.nextToken());

			src = new Item[N];
			select = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			// 풀이
			max = 0;

			subset(0);

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void subset(int srcIdx) {
		// 기저조건
		if (srcIdx == N) {
			// complete code
			int cal = 0;
			int point = 0;
			
			for(int i=0; i<N; i++) {
				if(!select[i]) continue; 
				cal += src[i].c;
				point += src[i].p;
			}
			// 조건에 맞는 max 갱신
			if(cal <= L) max = Math.max(max, point);

			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static class Item {
		int p, c;

		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
}
