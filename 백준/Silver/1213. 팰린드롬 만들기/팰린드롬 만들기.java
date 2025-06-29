import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int[] alpha = new int[26];
        for (char c : input) {
            alpha[c - 'A']++;
        }

        int oddCount = 0;
        int midCharIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                oddCount++;
                midCharIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            half.append(String.valueOf((char) (i + 'A')).repeat(alpha[i] / 2));
        }

        StringBuilder result = new StringBuilder();
        result.append(half);

        if (midCharIndex != -1) {
            result.append((char) (midCharIndex + 'A'));
        }

        result.append(half.reverse());

        System.out.println(result);
    }
}