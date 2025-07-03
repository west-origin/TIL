

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[][] arr = new int[n][2];
       
       for(int i = 0 ; i < n ; i++) {
           arr[i][0] = in.nextInt();
           arr[i][1] = in.nextInt();
       }
       
       Arrays.sort(arr, (e1, e2) -> {
           if (e1[1] == e2[1]) return e1[0] - e2[0]; 
           else {
               return e1[1] - e2[1];
           }
       });
       
       for(int i = 0 ; i < n ; i++) {
           System.out.println(arr[i][0]+" "+arr[i][1]);
       }
    }
}


