class Solution {
    public int[] solution(String[] wallpaper) {
        // (a,b) -> (height, width) -> arr[height][width]
        int windowHeight = wallpaper.length;
        int windowWidth = wallpaper[0].length();
        
        int minDragWidth = -1;
        int maxDragWidth = -1;
        int minDragHeight = -1;
        int maxDragHeight = -1;
        for(int i = 0; i < windowHeight; i++){
            char[] charArr = wallpaper[i].toCharArray();
            for(int j = 0; j < windowWidth; j++){
                if(charArr[j] == '#'){
                    if(minDragHeight == -1 || minDragHeight > i){
                       minDragHeight = i;
                    }
                    if(minDragWidth == -1 || minDragWidth > j){
                       minDragWidth = j;
                    }
                    if(maxDragHeight < i){
                        maxDragHeight = i;
                    }
                    if(maxDragWidth < j){
                        maxDragWidth = j;
                    }
                }
            }
        }
        
        int[] answer = new int[]{minDragHeight, minDragWidth, maxDragHeight + 1, maxDragWidth + 1};
        return answer;
    }
}
