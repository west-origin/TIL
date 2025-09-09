import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        String a = st.nextToken();
        String b = st.nextToken();
        Long frist = Long.parseLong(a+b);
        
        String c = st.nextToken();
        String d = st.nextToken();
        Long end = Long.parseLong(c+d);
        
        System.out.println(frist+end);
    }
}