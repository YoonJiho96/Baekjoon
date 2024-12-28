import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();
            br.readLine();

            int nMax = Collections.max(Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            int mMax = Collections.max(Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            sb.append(nMax >= mMax ? "S" : "B").append("\n");
        }
        System.out.println(sb);
    }
}