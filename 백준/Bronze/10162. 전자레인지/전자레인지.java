import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] times = {300, 60, 10};
        
        if (T % 10 != 0) {
            System.out.println(-1);
        } else {
            int n1 = T / times[0];
            T = T % times[0];

            int n2 = T / times[1];
            T = T % times[1];

            int n3 = T / times[2];

            System.out.println(n1 + " " + n2 + " " + n3);
        }
    }
}