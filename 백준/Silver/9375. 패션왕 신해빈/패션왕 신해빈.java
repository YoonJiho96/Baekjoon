import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.putIfAbsent(type, 0);
				map.put(type, map.get(type) + 1);
			}

			int result = 1;
			for (int n : map.values()) {
				result *= (n + 1);
			}
			result -= 1;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}