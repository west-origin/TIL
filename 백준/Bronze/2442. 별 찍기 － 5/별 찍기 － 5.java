import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = 2*n-1;
        
        for(int i = 0 ; i < n ; i++) {
            for(int x = 0 ; x+i < t/2 ; x++) {
                System.out.printf(" ");
            }
            for(int y = t/2-2 ; y <= (t/2-2)+i*2; y++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}