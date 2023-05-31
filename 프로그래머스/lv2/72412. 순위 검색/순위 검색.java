import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private final Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String eachInfo:info){
            String[] arr = eachInfo.split(" ");
            createInfoCase(arr, "", 0);
        }
        
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++){
            String[] arr =query[i].replaceAll(" and ","").split(" ");

            if(map.containsKey(arr[0])){
                answer[i] = binarySearch(arr[0], Integer.parseInt(arr[1]));
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private void createInfoCase(String[] arr, String str, int cnt){
        if(cnt == 4){
            List<Integer> list = map.getOrDefault(str, new ArrayList<Integer>());
            list.add(Integer.parseInt(arr[4]));
            if(list.size() == 1){
                map.put(str, list);
            }
            return;
        }
        createInfoCase(arr, str+"-", cnt+1);
        createInfoCase(arr, str+arr[cnt], cnt+1);
    }
    
    private int binarySearch(String query, int score){        
        List<Integer> list = map.get(query);
        int start = 0;
        int end = list.size()-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            
            if(list.get(mid) < score){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return list.size() - start;
    }
    
}