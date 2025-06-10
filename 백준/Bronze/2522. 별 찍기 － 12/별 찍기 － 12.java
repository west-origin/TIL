import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // n=3
        
        for(int i = 1 ; i <= n ; i++) {
            for(int x = 0; x+i < n ; x++) {      // 2 1 
                System.out.printf(" ");
            }
            for(int y = n ; y < n+i ; y++) {      // 1 2 3
                System.out.printf("*");
            }
            System.out.println();
        }
        
        for(int j = 0 ; j < (n-1) ; j++) {
            for(int x = (n-1) ; x <= (n-1) + j ; x++ ) {
                System.out.printf(" "); // 1 2
            }
            for(int y = 0; y+j < (n-1) ; y++ ) {
                System.out.printf("*"); // 2 1
            }
            System.out.println();
        }
    }
}


