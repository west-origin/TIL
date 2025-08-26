

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int[] arr = new int[26];
        for(int i = 0 ; i < 26 ; i++) {
            for(int j = 0 ; j < str.length(); j++) {
                if(i==(int)str.charAt(j)-97) {
                    arr[i] = j;
                    break;
                } else if(j == str.length()-1) {
                    arr[i] = -1;
                }
            }
        }
        for(int i = 0; i<26 ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}