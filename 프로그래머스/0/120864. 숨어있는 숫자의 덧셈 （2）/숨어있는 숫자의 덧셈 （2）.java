class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String str = "";
        str = my_string.replaceAll("[^0-9]", " ");
        String[] array = str.split(" ");
        for(String n : array) {
            if(!n.isEmpty()) {
                answer += Integer.parseInt(n);
            }
        }
        return answer;
    }
} 