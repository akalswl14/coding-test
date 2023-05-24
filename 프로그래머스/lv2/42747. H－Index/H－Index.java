import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for(int i:citations){
            list.add(i);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        for(int i = citations.length-1;i>=0;i--){
            int value = 0;
            if(list.get(i) < i + 1){
                value = list.get(i);
            }else{
                value = i+1;
            }
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}