import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
	static List<Character> opens = Arrays.asList('(', '[', '{', '<');
	static List<Character> closes = Arrays.asList(')', ']', '}', '>');

	public static void main(String[] args) throws Exception {
		int T = 10;
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			int cnt = Integer.parseInt(br.readLine());
			char[] inputs = br.readLine().toCharArray();

			Deque<Character> stack = new ArrayDeque<>(); // 원문 스택.
			for (int i = inputs.length - 1; i >= 0; i--) {
				stack.push(inputs[i]);
			}

			Deque<Character> popStack = new ArrayDeque<>(); // 뽑아놓은 스택.
			boolean isValid = false;
			while (!stack.isEmpty()) {
				char nextChar = stack.pop();

				// 여는 괄호가 새로 들어옴
				if (opens.contains(nextChar)) {
					if (popStack.isEmpty()) {
						popStack.push(nextChar);
					} else {
						char prevChar = popStack.pop();
						// 이전것도 여는 괄호면 넣고
						if (opens.contains(prevChar)) {
							popStack.push(prevChar);
							popStack.push(nextChar);
						}
						// 이전것이 닫든 괄호면 오류
						else {
							isValid = false;
							break;
						}
					}
				}
				// 닫는 괄호가 새로 들어옴
				else {
					if (popStack.isEmpty()) {
						popStack.push(nextChar);
					} else {
						char prevChar = popStack.pop();
						// 이전 것이 여는 괄호면 짝이 맞는지 검사
						if (opens.contains(prevChar)) {
							if (opens.get(closes.indexOf(nextChar)) == prevChar) {
								isValid = true;
							} else {
								isValid = false;
								break;
							}

							// 이전 것이 닫는 괄호면 넣음
						} else {
							popStack.push(prevChar);
							popStack.push(nextChar);
						}
					}
				}
			}
			System.out.println("#"+ t + " " + (isValid? '1':'0'));
		}
	}
}
