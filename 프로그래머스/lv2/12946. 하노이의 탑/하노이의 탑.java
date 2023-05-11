import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

class Solution {
    private List<int[]> list = new LinkedList<>();
    
    public int[][] solution(int n) {
        recursion(1,3,n);
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void recursion(int from, int to, int n){
        if(n==1){
            list.add(new int[]{from,to});
        }else{
            int stopOver = getStopOver(from,to);
            recursion(from,stopOver,n-1);
            list.add(new int[]{from,to});
            recursion(stopOver,to,n-1);
        }
    }
    
    private int getStopOver(int from, int to){
        if(from * to == 6) return 1;
        else if(from * to == 3) return 2;
        else return 3;
    }
}