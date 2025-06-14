import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        boolean[][] visited = new boolean[N][N];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == (N - 1) && node.x == (N - 1)) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            for (int i = 0; i < 2; i++) {
                int ny = node.y + dy[i] * map[node.y][node.x];
                int nx = node.x + dx[i] * map[node.y][node.x];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N)
                    continue;

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny, nx));
                }
            }
        }
        System.out.println("Hing");
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}