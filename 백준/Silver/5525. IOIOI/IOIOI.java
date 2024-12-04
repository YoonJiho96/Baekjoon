import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] inputs = br.readLine().toCharArray();

        // 연속되는 패턴 목록
        List<String> patterns = new ArrayList<>();

        // IOI... 가 얼마나 이어지는지 확인
        List<Character> temp = new ArrayList<>();
        for (char c : inputs) {
            // 비어 있으면 새로 넣기
            if (temp.isEmpty()) {
                if (c == 'I') {
                    temp.add('I');
                }
            }
            // 아니면 이어서 넣기
            else {
                // 현재가 I인데
                if (c == 'I') {
                    // 이전이 I => 이전까지 있던게 끝
                    if (temp.get(temp.size() - 1) == 'I') {
                        if (temp.size() >= 3) {
                            // 3 이상일 때만 들어감
                            patterns.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
                        }
                        temp = new ArrayList<>();
                        temp.add('I');
                    }
                    // 이전이 O => 이어서 작성
                    else {
                        temp.add('I');
                    }
                }
                // 현재가 O
                else {
                    // 이전이 I => 이어서 작성
                    if (temp.get(temp.size() - 1) == 'I') {
                        temp.add('O');
                    }
                    // 이전이 O => 현재거 폐기
                    else {
                        if (temp.size() >= 3) {
                            patterns.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
                        }
                        temp = new ArrayList<>();
                    }
                }
            }
        }

        // 반복문 종료 후 남아있는 temp 처리
        if (temp.size() >= 3) {
            patterns.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        int result = 0;
        int size = N * 2 + 1;
        for (String s : patterns) {
            int count = s.length() - size;
            if (count >= 0) {
                result += (count / 2) + 1;
            }
        }

        System.out.println(result);
    }
}