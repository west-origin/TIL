import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        for(int i = 1 ; i <= a ; i++) {
            for(int j = 0; j < a-i ; j++) {
                System.out.printf(" ");
            }
            for(int x = 0 ; x < i ; x++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}