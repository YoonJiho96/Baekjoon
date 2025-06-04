import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int MAX = 0;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int off = Integer.parseInt(st.nextToken());
            int on = Integer.parseInt(st.nextToken());

            count = count - off + on;
            MAX = Math.max(MAX, count);
        }
        System.out.println(MAX);
    }
}