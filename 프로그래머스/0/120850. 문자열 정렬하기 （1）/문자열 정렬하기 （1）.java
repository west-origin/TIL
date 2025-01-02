
import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[^0-9]", "");
        System.out.println("str.length(): "+str.length());
        int[] answer = new int[str.length()];
        for(int i = 0 ; i < str.length(); i++) {
            answer[i] = Integer.parseInt(str.substring(i,i+1));
        }
        Arrays.sort(answer);
        return answer;
    }
}