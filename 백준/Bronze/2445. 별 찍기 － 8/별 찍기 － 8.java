import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 1 ; i <= n ; i++) {
            for(int x = n ; x < n+i ; x++ ) {
                System.out.printf("*");
            }
            for(int y = 0 ; y < (2*n) - (i*2) ; y++) {
                System.out.printf(" ");
            }
            for(int z = n ; z < n+i ; z++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        
        for(int j = 1 ; j <= n-1 ; j++) {
            for(int x = 0 ; x+j <= n-1 ; x++ ) {
                System.out.printf("*");
            }
            for(int y = (n-1) ; y < (n-1)+(j*2) ; y++) {
                System.out.printf(" ");
            }
            for(int z = 0; z+j <= n-1 ; z++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}


