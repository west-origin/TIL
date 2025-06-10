
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sum = 0;
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int i = 0; i < x ; i++) {
            sum += month[i];
        }
        int a = (sum + y) % 7;
        System.out.println(day[a]);
    }
}