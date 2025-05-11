import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            sb.append(isPalindrome(str)).append(" ").append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
    }

    static int count = 0;

    public static int recursion(String s, int l, int r) {
        count += 1;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}