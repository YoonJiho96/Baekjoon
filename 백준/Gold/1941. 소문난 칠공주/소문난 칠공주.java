import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] map = new char[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            System.arraycopy(tmp, 0, map[i], 0, 5);
        }

        comb(0, 0);
        System.out.println(result);
    }

    static int[] tgt = new int[7];

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 7) {
            check();
            return;
        }

        for (int i = srcIdx; i < 25; i++) {
            tgt[tgtIdx] = i;
            comb(i + 1, tgtIdx + 1);
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = 0;

    static void check() {
        int[][] pos = new int[7][2];
        boolean[][] visited = new boolean[5][5];
        boolean[][] contained = new boolean[5][5];

        for (int i = 0; i < tgt.length; i++) {
            int n = tgt[i];
            pos[i][0] = n / 5;
            pos[i][1] = n % 5;
            contained[n / 5][n % 5] = true;
        }

        // 이어졌는지 확인
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(pos[0]);
        visited[pos[0][0]][pos[0][1]] = true;

        int count = 0;
        int yCount = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            count += 1;
            if (map[cur[0]][cur[1]] == 'Y') yCount += 1;
            if (yCount > 3) return;

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= 5 || nx >= 5 || ny < 0 || nx < 0) continue;
                if (!contained[ny][nx] || visited[ny][nx]) continue;

                que.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }

        if (count == 7) {
            result += 1;
        }
    }
}