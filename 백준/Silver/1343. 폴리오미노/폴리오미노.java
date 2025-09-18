import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String input = br.readLine();
        input = input.replaceAll("XXXX", "AAAA");
        input = input.replaceAll("XX", "BB");

        if (input.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(input);
        }
    }
}