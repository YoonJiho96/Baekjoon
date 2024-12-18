import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 8; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0 && line[j] == 'F') {
                    count++;
                } else if (i % 2 != 0 && j % 2 != 0 && line[j] == 'F') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}