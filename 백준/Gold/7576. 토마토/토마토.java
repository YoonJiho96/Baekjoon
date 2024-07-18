import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] arr;
    static int origin_tomato = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if(arr[i][j] == 0) {
                    origin_tomato += 1;
                }
            }
        }

        bfs();
    }

    static Queue<int[]> queue = new ArrayDeque<>();

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            day += 1;
            for(int s = 0; s < size; s++) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = pos[0] + dy[i];
                    int nx = pos[1] + dx[i];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                        continue;
                    }

                    if (arr[ny][nx] == 0) {
                        arr[ny][nx] = 1;
                        origin_tomato -= 1;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        if(origin_tomato == 0) {
            System.out.println(day-1);
        }else {
            System.out.println(-1);
        }
    }
}
