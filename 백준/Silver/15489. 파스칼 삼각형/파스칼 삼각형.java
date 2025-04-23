import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int MAX = R + W;
        int[][] arr = new int[MAX][MAX];
        arr[0][0] = 1;
        for (int i = 1; i < MAX; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        int result = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                result += arr[R + i - 1][C + j - 1];
            }
        }
        System.out.println(result);
    }
}