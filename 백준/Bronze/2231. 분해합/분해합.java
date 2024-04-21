import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int num = 1;
		while (num < N) {
			int sum = num;
			char[] arr = Integer.toString(num).toCharArray();

			for (char c : arr) {
				sum += c - '0';
			}

			if (sum == N) {
				System.out.println(num);
				return;
			}
			num++;
		}
		System.out.println(0);
	}
}