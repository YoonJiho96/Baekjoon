import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(isPalindrome(convert(A, n)) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    static String convert(long A, int n) {
        StringBuilder sb = new StringBuilder();
        long num = A;
        while (num > 0) {
            if (num % n < 10) {
                sb.append(num % n);
            } else {
                sb.append((char) (num % n - 10 + 'A'));
            }
            num /= n;
        }
        return sb.reverse().toString();
    }

    static boolean isPalindrome(String num) {
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}