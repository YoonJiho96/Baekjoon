import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] score = {4, 3, 2, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        float result = 0.0f;
        result += score[str.charAt(0) - 'A'];
        if (str.length() > 1) {
            char temp = str.charAt(1);
            if (temp == '+') result += 0.3f;
            else if (temp == '-') result -= 0.3f;
        }
        System.out.println(result);
    }
}