import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String asc = "12345678";
    static String des = "87654321";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().replace(" ", "");
        if(input.equals(asc)) {
            System.out.println("ascending");
        }else if (input.equals(des)) {
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }
    }
}