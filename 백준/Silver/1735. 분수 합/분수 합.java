import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int gcd = gcd(b1, b2);  // 최대공약수
        int lcm = (b1 * b2) / gcd;  // 최소공배수
        int A1 = a1 * (lcm / b1);
        int A2 = a2 * (lcm / b2);

        int aResult = A1 + A2;
        int resultGcd = gcd(aResult, lcm);
        if (resultGcd == 1) {
            System.out.println(aResult + " " + lcm);
        } else {
            System.out.println(aResult / resultGcd + " " + lcm / resultGcd);
        }
    }

    static int gcd(int a, int b) {
        int n;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}