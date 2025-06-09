import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        
        String line = bf.readLine();
        char[] ch = line.toCharArray();
        int sum = 0;
        for(int i = 0; i < tc; i++) {
            int no = Character.getNumericValue(ch[i]);
            sum = sum + no;
        }
        System.out.println(sum);
    }
}