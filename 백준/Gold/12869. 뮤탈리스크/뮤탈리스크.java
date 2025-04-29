import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][][] visited = new boolean[61][61][61];
    static int[][] dmg = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BFS(arr[0], arr[1], arr[2]));
    }

    static int BFS(int a, int b, int c) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(a, b, c, 0));
        visited[a][b][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.a == 0 && node.b == 0 && node.c == 0) {
                return node.count;
            }

            for (int[] d : dmg) {
                int na = Math.max(0, node.a - d[0]);
                int nb = Math.max(0, node.b - d[1]);
                int nc = Math.max(0, node.c - d[2]);

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    queue.offer(new Node(na, nb, nc, node.count + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int a, b, c, count;

        Node(int a, int b, int c, int count) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.count = count;
        }
    }
}