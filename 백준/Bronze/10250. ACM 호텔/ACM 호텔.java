import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, H, W, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			int m = N / H;
			int n = N % H;

			int floor = n + ((n == 0) ? H : 0);
			int step = m + ((n == 0) ? 0 : 1);
			
			sb.append(floor);
			if(String.valueOf(step).length() == 1) {
				sb.append(0);
			}
			sb.append(step).append("\n");
		}
		System.out.println(sb);
	}
}