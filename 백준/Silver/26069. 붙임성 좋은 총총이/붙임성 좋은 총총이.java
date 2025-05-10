import java.io.BufferedReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if(set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }

        System.out.println(set.size());
    }
}