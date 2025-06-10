import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        for(int i = 0 ; i < a ; i++) {
            for(int j = a-i ; j > 0  ; j--) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}