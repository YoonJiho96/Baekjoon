import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>(Map.of(
                "NLCS", "North London Collegiate School",
                "BHA", "Branksome Hall Asia",
                "KIS", "Korea International School",
                "SJA", "St. Johnsbury Academy"
        ));
        System.out.println(map.get(br.readLine()));
    }
}