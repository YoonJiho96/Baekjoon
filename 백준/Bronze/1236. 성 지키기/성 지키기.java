import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (str[j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            if (!row[i]) {
                rowCount++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (!col[i]) {
                colCount++;
            }
        }
        System.out.println(Math.max(rowCount, colCount));
    }
}