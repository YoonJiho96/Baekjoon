import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && a == b && b == c)
				break;
			int[] list = new int[] { a, b, c };
			Arrays.sort(list);

			if (a == b && b == c) {
				sb.append("Equilateral");
			} else if (list[2] >= list[0] + list[1] || a == 0 || b == 0 || c == 0) {
				sb.append("Invalid");
			} else if (a == b || b == c || a == c) {
				sb.append("Isosceles");
			} else {
				sb.append("Scalene");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}