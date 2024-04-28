import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) stack.pop();
            else stack.push(n);
        }
        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());
    }
}