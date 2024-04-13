import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[10][10];
	static boolean[][] select = new boolean[10][10];
	static int[] endPos = new int[2];
	static char[][] result = new char[10][10];
	static int[] ships = { 0, 4, 3, 2, 1 }; // 각각 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 100) {
					endPos[0] = i;
					endPos[1] = j;

				}
				result[i][j] = '.';
			}
		}

		// 마지막 위치에 놓기. 주변 못놓게 막아야함
		placeShip(endPos[0], endPos[1], 1);

		// 처음좌표부터 시작해서 놓기
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (select[i][j])
					continue;
				for (int s = 1; s <= 4; s++) {
					if (ships[s] <= 0)
						continue;
					if (canPlace(i, j, s)) {
						placeShip(i, j, s);
					}
				}
			}
		}

		printMap();
	}

	static StringBuilder sb = new StringBuilder();

	static void printMap() {
		for (char[] ca : result) {
			for (char c : ca) {
				sb.append(c);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	// 배치하기
	static void placeShip(int y, int x, int len) {
		for (int i = -1; i <= 1; i++) {
			int cy = y + i;
			for (int j = -1; j <= len; j++) {
				int cx = x + j;
				if (isValid(cy, cx)) {
					select[cy][cx] = true;
				}
			}
		}

		for (int i = x; i < (x + len); i++) {
			result[y][i] = '#';
		}
		ships[len] -= 1;
	}

	// 배치 여부
	static boolean canPlace(int y, int x, int len) {
		for (int i = x; i < (x + len); i++) {
			if (!isValid(y, i))
				return false;
			if (select[y][i])
				return false;
		}
		return true;
	}

	// 맵 범위 체크
	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= 10 || x >= 10) {
			return false;
		} else {
			return true;
		}
	}
}