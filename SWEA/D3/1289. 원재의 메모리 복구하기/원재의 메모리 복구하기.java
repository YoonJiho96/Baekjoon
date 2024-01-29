import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String in = br.readLine();
			int[] inputs = new int[in.length()];
			int[] origin = new int[in.length()];

			int result = 0;

			for (int j = 0; j < in.length(); j++) {
				inputs[j] = (in.charAt(j)) - '0';
			}

			for (int j = 0; j < inputs.length; j++) {
				if (inputs[j] == origin[j])	continue;
				for (int k = j; k < inputs.length; k++) {					
					origin[k] = (origin[k] == 0) ? 1:0;
				}
				result++;
			}

			System.out.printf("#%d %d\n", (i + 1), result);
		}
	}

}
