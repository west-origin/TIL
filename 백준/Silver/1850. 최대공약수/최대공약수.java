
import java.util.Scanner;

public class Main {

    static Long getGCD(Long a, Long b) {
        if(b%a == 0) {
            return a;
        } else {
            
            return getGCD((b%a),a);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        Long a = sc.nextLong();
        Long b = sc.nextLong();
        for(int i = 0 ; i < getGCD(a,b) ; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }
}