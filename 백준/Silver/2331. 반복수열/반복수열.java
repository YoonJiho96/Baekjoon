import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 1;
        while (true) {
            int[] num = String.valueOf(A).chars().map(e -> e - '0').toArray();
            int sum = 0;
            for (int n : num) {
                sum += (int) Math.pow(n, P);
            }

            if (!map.containsKey(A)) {
                map.put(A, count++);
                A = sum;
            } else {
                System.out.println(map.get(A) - 1);
                return;
            }
        }
    }
}