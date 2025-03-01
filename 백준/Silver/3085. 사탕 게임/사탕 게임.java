import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 두 칸 골라서 검사하기
        getChanges();
        System.out.println(answer);
    }

    static void getChanges() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int y = i;
                int x = j;

                // 가로 체크
                int y1 = y;
                int x1 = x + 1;

                // 세로 체크
                int y2 = y + 1;
                int x2 = x;

                if (x1 < N) checkValid(y, x, y1, x1);
                if (y2 < N) checkValid(y, x, y2, x2);
            }
        }
    }

    static int answer = 0;

    static void checkValid(int y1, int x1, int y2, int x2) {
        swap(y1, x1, y2, x2);

        // 교환 영향 받은 행,열만 체크
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        rows.add(y1);
        rows.add(y2);
        cols.add(x1);
        cols.add(x2);

        for (int y : rows) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (map[y][j] == map[y][j - 1])
                    count++;
                else
                    count = 1;
                answer = Math.max(answer, count);
            }
        }

        for (int x : cols) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (map[j][x] == map[j - 1][x])
                    count++;
                else
                    count = 1;
                answer = Math.max(answer, count);
            }
        }

        // 되돌리기
        swap(y1, x1, y2, x2);
    }

    static void swap(int y1, int x1, int y2, int x2) {
        char temp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = temp;
    }
}