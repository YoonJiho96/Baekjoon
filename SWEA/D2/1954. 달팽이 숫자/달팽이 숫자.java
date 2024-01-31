import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] snail = new int[N][N];

			int count = 1;
			int x = -1;
			int y = 0;
			int dir = 0;
			
			while (count <= N * N) {
				int nextX = x + (dx[dir]);
				int nextY = y + (dy[dir]);
				if (nextX >= N || nextX < 0 || nextY >= N || nextY < 0 || snail[nextY][nextX] != 0) {
					dir = (dir + 1) % 4;
					nextX = x + (dx[dir]);
					nextY = y + (dy[dir]);
				}
				x = nextX;
				y = nextY;
				snail[y][x] = count++;
			}

			sb.append("#").append(t).append("\n");
			
			for(int[] a : snail) {
				for(int b: a) {
					sb.append(b).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}