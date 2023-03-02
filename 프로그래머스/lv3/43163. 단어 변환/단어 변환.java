import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    class WordClass{
        String word;
        int cnt;
        
        WordClass(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        boolean[] checked = new boolean[words.length];
        Queue<WordClass> q = new LinkedList<WordClass>();
        
        q.offer(new WordClass(begin, 1));
        
        while(!q.isEmpty()){
            WordClass newWordClass = q.poll();
            String newStr = newWordClass.word;
            
            for(int i = 0; i < words.length; i++){
                if(checked[i]) continue;
                
                String checking = words[i];
                if(onlyOneCharDiffer(newStr, checking)){
                    if(checking.equals(target)) return newWordClass.cnt;
                        
                    checked[i] = true;
                    q.offer(new WordClass(checking, newWordClass.cnt + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean onlyOneCharDiffer(String str1, String str2){
        int cntDifferChar = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                cntDifferChar++;
            }
        }
        return cntDifferChar == 1 ? true : false;
    }
}