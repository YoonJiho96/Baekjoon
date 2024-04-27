import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		long sum = 0;
		
		long[] pow31 = new long[50];
		pow31[0] = 1;
		for(int i=1; i<50; i++) {
			pow31[i] = (pow31[i-1] * 31) % M;
		}
		
		for (int i = 0; i < N; i++) {
			long num = (input[i] - 96) * pow31[i];
			num %= M;
			sum += num;
		}
		long result = sum % M;
		System.out.println(result);
	}
}