import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j] : (i, j) 에서 이동할 수 있는 최대 거리
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAX = Math.max(MAX, dfs(i, j));
            }
        }

        System.out.println(MAX);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int MAX = 1;

    static int dfs(int y, int x) {
        // (y, x) 에서 최대 길이를 구한 적 있음
        if (dp[y][x] != 0) return dp[y][x];
        
        // (y, x) 현재 위치 포함 초기화
        dp[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (map[ny][nx] > map[y][x]) {
                // 현재 위치에서 이동 가능한 모든 위치에서 가능한 거리
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }
        }
        return dp[y][x];
    }
}