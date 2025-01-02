import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int age) {
        String answer = "";
        char[] alphabets = {'a','b','c','d','e','f','g','h','i','j'};
        Map<String, String> code = new HashMap<>();
        int i = 0;
        for(char al : alphabets) {
            code.put(String.valueOf(i), String.valueOf(al));
            i++;
        }
        String test = age + "";
        for(int j = 0 ; j < test.length() ; j++) {
            String digit = test.substring(j, j+1);
            answer+=code.get(digit);
        }
        return answer;
    }
}