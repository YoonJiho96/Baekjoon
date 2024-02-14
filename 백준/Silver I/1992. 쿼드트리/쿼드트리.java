import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        check(N, 0, 0);
        System.out.println(sb);
    }

    static void check(int n, int y, int x) {
        if( n == 1 ) {
            sb.append(map[y][x]);
            return;
        }

        // 현재 범위의 값이 같은지 확인
        boolean isValid = true;
        int num = map[y][x];
        for(int i=y; i<y+n; i++) {
            for(int j=x; j<x+n; j++) {
                if(num != map[i][j]) {
                    isValid = false;
                    break;
                }
            }
            if(!isValid) break;
        }

        // 같지 않으면 4분할
        if(!isValid) {
            n = n / 2;
            sb.append("(");
            check(n, y, x);
            check(n, y, x+n);
            check(n, y+n, x);
            check(n, y+n, x+n);
            sb.append(")");
        } else {
            sb.append(map[y][x]);
            return;
        }
    }
}