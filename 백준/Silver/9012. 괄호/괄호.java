

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            System.out.println(solution(br.readLine()));
        }
    }
    
    public static String solution(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int j=0 ; j<str.length(); j++) {
            if(str.charAt(j)=='(') {
                stack.push(str.charAt(j));
            } else {
                if(stack.empty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.empty()?"YES":"NO";
    }
}