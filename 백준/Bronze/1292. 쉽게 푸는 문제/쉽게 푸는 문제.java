import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; list.size() < B; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}