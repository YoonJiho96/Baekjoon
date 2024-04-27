import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			long num = (input[i] - 96) * (long) Math.pow(31, i);
			num %= M;
			sum += num;
		}
		long result = sum;
		System.out.println(result);
	}
}