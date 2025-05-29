import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        
        for(int i = 0 ; i < tc ; i++) {
            String str = sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.println(a+b);
        }
    }
} 