
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++) {
            for(int x = 1; x+i < n ; x++) { // 4 3 2 1 0
                System.out.printf(" ");
            }
            for(int y = n ; y <= n+i ; y++) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}


