import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.parseInt(reverse(st.nextToken())) + Integer.parseInt(reverse(st.nextToken()));
        System.out.println(Integer.parseInt(reverse(String.valueOf(result))));
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}