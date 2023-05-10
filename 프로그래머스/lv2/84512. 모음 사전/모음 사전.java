import java.util.LinkedList;
import java.util.List;
    
public class Solution {
    private static final char[] CHARS = new char[]{'A','E','I','O','U'};
    private static final List<String> words = new LinkedList<>();
    
    private void generate(String word) {
        words.add(word);
    
        if (word.length() == 5) {return;}
    
        for (char c : CHARS) {
            generate(word+c);
        }
    }
    
    public int solution(String word) {
        generate("");
        return words.indexOf(word);
    }
}