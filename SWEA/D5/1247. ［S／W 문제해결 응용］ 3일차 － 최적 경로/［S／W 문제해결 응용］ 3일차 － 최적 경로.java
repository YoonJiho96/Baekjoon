import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, min;
	static int[] startPos, endPos;
	static int[][] list, temp;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			visit = new boolean[N];
			list = new int[N][2];
			temp = new int[N][2];
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 출발 도착 좌표
			startPos = new int[2];
			endPos = new int[2];
			startPos[0] = Integer.parseInt(st.nextToken());
			startPos[1] = Integer.parseInt(st.nextToken());
			endPos[0] = Integer.parseInt(st.nextToken());
			endPos[1] = Integer.parseInt(st.nextToken());

			// 나머지 좌표
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i][0] = x;
				list[i][1] = y;
			}

			perm(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int tgtIdx, int dis) {
		if (tgtIdx == N) {
			// 최소값 검사.
			int result = dis + getDis(endPos, temp[tgtIdx - 1]);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			temp[tgtIdx] = list[i];
			visit[i] = true;
			if (tgtIdx == 0) {
				perm(tgtIdx + 1, getDis(temp[tgtIdx], startPos));
			} else {
				perm(tgtIdx + 1, dis + getDis(temp[tgtIdx], temp[tgtIdx - 1]));
			}
			visit[i] = false;
		}
	}

	static int getDis(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}
}