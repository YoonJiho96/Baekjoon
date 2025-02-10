import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : string) {
            sb.append((char) (c <= 90 ? c + 32 : c - 32));
        }
        System.out.println(sb);
    }
}