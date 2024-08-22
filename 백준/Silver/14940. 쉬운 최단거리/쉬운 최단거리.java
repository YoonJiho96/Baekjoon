import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sY, sX;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sY = i;
                    sX = j;
                }
            }
        }
        BFS(sY, sX);

        StringBuilder sb = getStringBuilder();
        System.out.println(sb);
    }

    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(result[i][j] == 0) {
                    if(result[i][j] == map[i][j]) {
                        sb.append(result[i][j]);
                    } else if(map[i][j] == 2)
                    {
                        sb.append(result[i][j]);
                    }
                    else {
                        sb.append(-1);
                    }
                } else {
                    sb.append(result[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    static int[][] result;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void BFS(int y, int x) {
        result = new int[N][M];
        visit = new boolean[N][M];

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y, x});
        visit[y][x] = true;

        int count = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            count += 1;

            for (int s = 0; s < size; s++) {
                int[] cur = que.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if (!valid(ny, nx) || visit[ny][nx] || map[ny][nx] == 0) {
                        continue;
                    }

                    que.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    result[ny][nx] = count;
                }
            }
        }
    }

    static boolean valid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
