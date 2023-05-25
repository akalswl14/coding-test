import java.util.PriorityQueue;
import java.util.Collections;
import java.lang.StringBuilder;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1,o2)->(o2+o1).compareTo(o1+o2));
        
        for(int num:numbers){
            queue.add(Integer.toString(num));
        }
        
        if(queue.peek().charAt(0) == '0'){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        
        return sb.toString();
    }
}