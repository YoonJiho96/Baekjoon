import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        final int START_YEAR = 2024;
        final int START_MONTH = 1;
        final int MONTHS_IN_YEAR = 12;

        int totalMonths = START_MONTH + N * 7;
        int targetYear = START_YEAR + (totalMonths - 1) / MONTHS_IN_YEAR;
        int targetMonth = (totalMonths - 1) % MONTHS_IN_YEAR + 1;

        System.out.println(targetYear + " " + targetMonth);
    }
}