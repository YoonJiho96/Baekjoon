import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int digitalRoot(String num) {
        int mod = 0;
        for (int i = 0; i < num.length(); i++) {
            mod = (mod + (num.charAt(i) - '0')) % 9;
        }
        return mod == 0 ? 9 : mod;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine().trim();
            if (line.equals("0")) break;
            sb.append(digitalRoot(line)).append("\n");
        }
        System.out.print(sb);
    }
}