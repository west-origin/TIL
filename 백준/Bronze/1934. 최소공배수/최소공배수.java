

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
                    
            int d = gcd(a, b);  // 최대공약수를 구해준다.
                    
            System.out.println(a * b / d);
        }
    }
    
    public static int gcd(int a, int b) {
        
        while (b != 0) {
            int r = a % b; // 나머지를 구해준다.
     
            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
}