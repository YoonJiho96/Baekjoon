import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            char temp = br.readLine().charAt(0);
            arr[temp - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                sb.append((char) ('a' + i));
            }
        }
        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}