import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = input[j - 1] - '0';

                // 바로 계산
                if (arr[i][j] == 0) continue;
                int min = Math.min(arr[i - 1][j - 1], Math.min(arr[i][j - 1], arr[i - 1][j]));

                // 최대 길이
                if (min == 0) arr[i][j] = 1;
                else arr[i][j] = min + 1;
                max = Math.max(max, arr[i][j]);
            }
        }

        // 크기 계산
        System.out.println(max * max);
    }
}