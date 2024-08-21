import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, white = 0, blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void check(int y, int x, int n) {
        if (isAllSameColor(y, x, n)) {
            if (arr[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            int half = n / 2;
            check(y, x, half);
            check(y, x + half, half);
            check(y + half, x, half);
            check(y + half, x + half, half);
        }
    }

    static boolean isAllSameColor(int y, int x, int n) {
        int color = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}