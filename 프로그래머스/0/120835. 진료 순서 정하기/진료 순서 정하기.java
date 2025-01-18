import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] copy = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Integer[] sorted = Arrays.copyOf(copy, copy.length);
        Arrays.sort(sorted, Collections.reverseOrder());
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (copy[i].equals(sorted[j])) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
