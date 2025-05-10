import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        HashSet<String> set = new HashSet<>();
        while (N-- > 0) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                set = new HashSet<>();
            } else {
                if (!set.contains(input)) {
                    set.add(input);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}