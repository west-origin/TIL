import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int t : arr) {
            sb.append(t).append('\n');
        }
        
        System.out.println(sb);
    }
}