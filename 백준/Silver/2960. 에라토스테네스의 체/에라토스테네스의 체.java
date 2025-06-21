import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] erased = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (erased[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (erased[j]) continue;
                count++;
                erased[j] = true;

                if (count == K) {
                    bw.write(String.valueOf(j));
                    bw.flush();
                    return;
                }
            }
        }
    }
}