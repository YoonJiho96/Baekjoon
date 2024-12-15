import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>(List.of(new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"}));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println((long) (((list.indexOf(br.readLine()) * 10L) + list.indexOf(br.readLine())) * Math.pow(10, list.indexOf(br.readLine()))));
    }
}