import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int con = 1;

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                result += con++;
            } else {
                con = 1;
            }
        }
        System.out.println(result);
    }
}