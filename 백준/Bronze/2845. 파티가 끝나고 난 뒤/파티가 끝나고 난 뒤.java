import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int NUM = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - NUM).append(" ");
        }
        System.out.println(sb);
    }
}