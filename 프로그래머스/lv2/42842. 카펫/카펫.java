class Solution {
    public int[] solution(int brown, int yellow) {
        // (brown-4)/2 = yW + yH <- sum
        int sum = (brown-4)/2;
        int yH = 1;
        int yW = sum-1;
        
        while(!(yW*yH == yellow && yellow%yH == 0)){
            yH++;
            yW = sum-yH;
        }
        
        return new int[]{yW+2, yH+2};
    }
}