import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 2][C + 2];
        char[][] after = new char[R + 2][C + 2];

        for (int i = 0; i < R + 2; i++) {
            Arrays.fill(after[i], '.');
            Arrays.fill(map[i], '.');
        }

        // map 초기화
        for (int i = 1; i <= R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= C; j++) {
                map[i][j] = after[i][j] = line[j - 1];
            }
        }

        // 침몰
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == 'X' && check(i, j)) {
                    after[i][j] = '.';
                }
            }
        }

        // 새 지도 구하기
        int minY = 10;
        int minX = 10;
        int maxY = 0;
        int maxX = 0;

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (after[i][j] == 'X') {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                sb.append(after[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 50년 후 바다가 되는지 체크
    static boolean check(int y, int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (map[ny][nx] == '.')
                count++;
        }
        return count >= 3;
    }
}