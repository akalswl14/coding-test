import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    List<String> result = new ArrayList<String>();
    String[][] tickets;
    
    
    class Node implements Comparable<Node>{
        int idx;
        String target;
        
        Node(int idx, String target){
            this.idx = idx;
            this.target = target;
        }
        
        @Override
        public int compareTo(Node node){
            return target.compareTo(node.target);
        }  
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        List<String> list = new ArrayList<String>();
        list.add("ICN");
        boolean[] checked = new boolean[tickets.length];
        dfs(new Node(-1, "ICN"), list, checked);
        
        String[] answer = new String[result.size()];
        for(int i =0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private boolean dfs(Node nowNode, List<String> answer, boolean[] checked){
        String now = nowNode.target;
        if(nowNode.idx >= 0){
            answer.add(now);
            checked[nowNode.idx] = true;   
        }
        
        if(answer.size() == tickets.length + 1){
            result = answer;
            return true;
        }

        List<Node> list = new ArrayList<Node>();
        for(int i = 0; i < tickets.length; i++){
            if(checked[i]) continue;
            
            if(now.equals(tickets[i][0])){
                list.add(new Node(i,tickets[i][1]));
            }
        }
        if(list.size() == 0){
            answer.remove(answer.size()-1);
            checked[nowNode.idx] = false;
            return false;
        }
        
        Collections.sort(list);
        for(int i = 0;i<list.size();i++){
            Node newNode = list.get(i);
            if(dfs(newNode, answer, checked)){
                return true;
            }
        }
        answer.remove(answer.size()-1);
        checked[nowNode.idx] = false;
        return false;
    }
}