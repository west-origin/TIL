import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0 ; i < n ; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }
        
        System.out.println(sb);
    }
    /**
     * NO 경우의 수 
     * 1. (((((((((((만 반복할 경우
     * 2. stack이 없을 때 )가 될 경우
     * 3. 
     */
    public static String solve(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.add('(');
            } else if(str.charAt(i) == ')') {
                if(stack.size() == 0) { 
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        
        if(stack.size() != 0) { // 안에 남아 있는 경우
            return "NO";
        } else {
            return "YES";
        }
    }
}