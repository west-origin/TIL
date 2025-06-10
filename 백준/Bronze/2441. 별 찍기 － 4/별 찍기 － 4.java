import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        for(int i = 0 ; i < a ; i++) {
            for(int j = a ; j-i < a ; j++) {
                System.out.printf(" ",j);
            }
            for(int x = 0 ; x < a-i ; x++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}

