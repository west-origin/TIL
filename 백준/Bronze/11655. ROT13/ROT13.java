import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < str.length() ; i++) {
            int num = 0;
            char ch;
            if( str.charAt(i) != ' ') {
                if(Character.isUpperCase(str.charAt(i))) {
                    num =(int)str.charAt(i)+13;
                    if(num > 90) {
                        ch=(char)(num-90+64);
                        sb.append(ch);
                    } else {
                        ch = (char)num;
                        sb.append(ch);
                    }
                } else if (Character.isLowerCase(str.charAt(i))) {
                    num =(int)str.charAt(i)+13;
                    if(num > 122) {
                        ch=(char)(num-122+96);   
                        sb.append(ch);
                    } else {
                        ch = (char)num;
                        sb.append(ch);
                    }
                } else {
                    num=str.charAt(i)-'0';
                    
                    sb.append(num);
                }
            } else {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }
}
