import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sY, sX;
    static int[][] map;
    static int[][] result;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sY = i;
                    sX = j;
                } else if (map[i][j] == 0) {
                    result[i][j] = 0; // 갈 수 없는 땅은 0으로 설정
                    visit[i][j] = true; // BFS에서 방문하지 않도록 설정
                } else {
                    result[i][j] = -1; // 기본적으로 도달할 수 없는 위치는 -1로 설정
                }
            }
        }
        BFS(sY, sX);

        System.out.print(getStringBuilder());
    }

    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    static void BFS(int y, int x) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y, x});
        visit[y][x] = true;
        result[y][x] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cy = cur[0];
            int cx = cur[1];
            int curDist = result[cy][cx];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (valid(ny, nx) && !visit[ny][nx] && map[ny][nx] == 1) {
                    que.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    result[ny][nx] = curDist + 1;
                }
            }
        }
    }

    static boolean valid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}