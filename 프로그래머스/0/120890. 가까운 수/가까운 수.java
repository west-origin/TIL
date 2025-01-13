class Solution {
    public int solution(int[] array, int n) {
        int closest = array[0];
        int minDifference = Math.abs(array[0] - n);
        
        for (int i = 1; i < array.length; i++) {
            int difference = Math.abs(array[i] - n);
            

            if (difference < minDifference) {
                minDifference = difference;
                closest = array[i];
            }

            else if (difference == minDifference && array[i] < closest) {
                closest = array[i];
            }
        }
        
        return closest;
    }
}
