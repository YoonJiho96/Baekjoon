import java.util.Scanner;

public class Main {
	static long A, B, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();

		result = Integer.MAX_VALUE;
		dfs(A, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result + 1);
	}

	static void dfs(long num, int dep) {
		if (num > B) {
			return;
		}
		if (num == B) {
			result = Math.min(result, dep);
			return;
		}
		dfs(num * 2, dep + 1);
		dfs(num * 10 + 1, dep + 1);
	}
}