import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Student{
        String name;
        int kor;
        int eng;
        int math;
        
        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        ArrayList<Student> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            
            list.add(new Student(name, kor, eng, math));
        }
        
        list.sort((e1, e2) -> {
            if(e1.kor != e2.kor) {
                return e2.kor - e1.kor;
            } else if(e1.eng != e2.eng) {
                return e1.eng - e2.eng;
            } else if(e1.math != e2.math) {
                return e2.math - e1.math;
            } else {
                return e1.name.compareTo(e2.name);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(Student t : list) {
            sb.append(t.name).append('\n');
        }
        System.out.println(sb);
    }
}