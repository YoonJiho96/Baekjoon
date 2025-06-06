import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input[j]));
            }
        }

        int MAX = 1;
        int length = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 범위 체크
                for (int r = 2; r <= length; r++) {
                    if (check(i, j, r)) {
                        MAX = Math.max(MAX, r * r);
                    }
                }
            }
        }
        System.out.println(MAX);
    }

    static boolean check(int y, int x, int len) {
        int cur = map[y][x];

        int y2 = y + len - 1;
        int x2 = x + len - 1;

        if (y2 >= N || x2 >= M) {
            return false;
        }
        return map[y][x2] == cur && map[y2][x2] == cur && map[y2][x] == cur;
    }
}