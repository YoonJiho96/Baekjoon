import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static char[][] input;
	static HashMap<Character, Integer> map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static List<Character> temp = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[R][C];
		for (int i = 0; i < R; i++) {
			input[i] = br.readLine().toCharArray();
		}

		max = 0;
		map = new HashMap<>();
		dfs(0, 0, 1);
		System.out.println(max);
	}

	static void dfs(int y, int x, int dis) {
		if (map.containsKey(input[y][x])) {
			return;
		}
		map.put(input[y][x], 0);
		max = Math.max(max, dis);

		for (int i = 0; i < 4; i++) {
			int nY = y + dy[i];
			int nX = x + dx[i];

			if (nY < 0 || nY >= R || nX < 0 || nX >= C)
				continue;
			dfs(nY, nX, dis + 1);
		}
		map.remove(input[y][x]);
	}
}