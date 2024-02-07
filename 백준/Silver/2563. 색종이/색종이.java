import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int j=y; j<y+10; j++) {
                for(int k=x; k<x+10; k++) {
                    map[j][k] = 1;
                }
            }
        }
        int result = 0;
        for(int[] a : map) {
            result += Arrays.stream(a).sum();
        }
        System.out.println(result);
    }
}