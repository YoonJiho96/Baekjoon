import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Long, Long> map = new HashMap<>();
    static long P, Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map.put(0L, 1L);
        System.out.println(GetA(n));
    }

    static Long GetA(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long left = GetA(n / P);
            long right = GetA(n / Q);

            map.put(n, left + right);
            return left + right;
        }
    }
}