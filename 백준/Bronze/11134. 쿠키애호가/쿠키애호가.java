import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            long days = (N + C - 1) / C;
            sb.append(days).append("\n");
        }
        System.out.println(sb);
    }
}