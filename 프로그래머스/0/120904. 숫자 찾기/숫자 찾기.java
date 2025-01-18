class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String a = k+"";
        String str=num+"";
        String[] array = new String[str.length()];
        for(int i = 0 ; i < str.length() ; i++) {
            array[i] = str.substring(i,i+1);
            System.out.println("array[i]: "+array[i]);
            
            if(array[i].equals(a)) {
                answer = i+1;
                break;
            } else {
                answer = -1;
            }
        }
        System.out.println("answer: "+answer);
        return answer;
    }
}