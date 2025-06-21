import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] erased = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            int cur = i;

            if (erased[cur]) continue;

            for (int j = cur; j <= N; j += cur) {
                if (erased[j]) continue;
                count++;
                erased[j] = true;

                if (count == K) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}