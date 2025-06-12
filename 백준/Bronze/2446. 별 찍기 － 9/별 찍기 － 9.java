import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();       // n=3
        int t = n*2-1;
        
        for(int i = 0 ; i < n ; i++) {
            for(int x = 0; x < 0+i ; x++) {
                System.out.printf(" ");
            }
            for(int y =0; y+(i*2) < t ; y++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        for(int j = 0 ; j < n-1 ; j++) {
            for(int x = 1 ; x+j < n-1 ; x++) {
                System.out.printf(" ");
            }
            for(int y = t ; (y-j*2)-3 < t ; y++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}


