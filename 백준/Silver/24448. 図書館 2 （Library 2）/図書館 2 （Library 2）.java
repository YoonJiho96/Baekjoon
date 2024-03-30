import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Deque<String> stack = new ArrayDeque<>();
		for(int q=0; q<Q; q++ ) {
			String input = br.readLine();
			if(input.equals("READ")) {
				sb.append(stack.pop()).append("\n");
				
			}else {
				stack.push(input);
			}
		}
		System.out.println(sb);
	}
}