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

        int[][] arr = new int[31][31];
        arr[1][1] = 1;
        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        int result = 0;
        int count = 1;
        for (int i = R; i < (R + W); i++) {
            for (int j = 0; j < count; j++) {
                result += arr[i][C + j];
            }
            count++;
        }
        System.out.println(result);
    }
}