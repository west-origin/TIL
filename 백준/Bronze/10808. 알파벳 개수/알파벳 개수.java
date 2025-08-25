
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++) {
            arr[(int)str.charAt(i)-97] += 1;
        }
        for(int n : arr) {
            System.out.print(n+" ");
        }
    }
}