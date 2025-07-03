
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    private static class Member{
        private int age;
        private String name;
        
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        List<Member> list = new ArrayList<>();
        
        
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }

        list.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        
        StringBuilder sb = new StringBuilder();
        for(Member a : list) {
            sb.append(a.age).append(' ').append(a.name).append('\n');
        }
        
        System.out.println(sb);
    }
}


