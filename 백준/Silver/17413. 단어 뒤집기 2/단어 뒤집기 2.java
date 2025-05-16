import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        boolean isTag = false;

        for (char c : input) {
            if (c == '<') {
                appendReverse(temp, sb); // 이전 단어 처리
                isTag = true;
                sb.append(c);
            } else if (c == '>') {
                isTag = false;
                sb.append(c);
            } else if (c == ' ') {
                if (isTag) {
                    sb.append(c);
                } else {
                    appendReverse(temp, sb);
                    sb.append(c);
                }
            } else {
                if (isTag) {
                    sb.append(c);
                } else {
                    temp.append(c);
                }
            }
        }

        appendReverse(temp, sb);
        System.out.println(sb);
    }

    private static void appendReverse(StringBuilder temp, StringBuilder main) {
        main.append(temp.reverse());
        temp.setLength(0);
    }
}