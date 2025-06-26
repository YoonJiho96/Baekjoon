import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            int lowCount = 0;
            int highCount = 0;
            int numCount = 0;
            int spaceCount = 0;

            for (char c : str.toCharArray()) {
                if (c >= 'a' && c <= 'z') lowCount++;
                else if (c >= 'A' && c <= 'Z') highCount++;
                else if (c >= '0' && c <= '9') numCount++;
                else if (c == ' ') spaceCount++;
            }
            sb.append(lowCount).append(" ").append(highCount).append(" ").append(numCount).append(" ").append(spaceCount).append("\n");
        }
        System.out.println(sb);
    }
}