import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 1 ; i <= T ; i++) {
            String line = bf.readLine();
            String[] str = line.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int sum = a+b;
            System.out.printf("Case #%d: %d\n",i, sum);
        }
    }
}