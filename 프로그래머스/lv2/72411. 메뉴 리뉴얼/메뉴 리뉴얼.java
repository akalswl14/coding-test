import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

  Map<String, Integer> map = new HashMap<>();
  int max;

  public String[] solution(String[] orders, int[] course) {
    List<String> list = new LinkedList<>();

    for (int c : course) {
      map = new HashMap<>();
      max = 2;
      for (String target : orders) {
        char[] arr = target.toCharArray();
        Arrays.sort(arr);
        combination(new String(arr), c);
      }

      for (Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() == max) {
          list.add(entry.getKey());
        }
      }
    }

    Collections.sort(list);
    return list.toArray(String[]::new);
  }

  private void combination(String target, int strLength) {
    for (int i = 0; i < target.length() - 1; i++) {
      combi_recursion(i, 0, new StringBuilder(), target, strLength);
    }
  }

  private void combi_recursion(int idx, int cnt, StringBuilder sb, String target, int strLength) {
    sb.append(target.charAt(idx));
    if (cnt + 1 == strLength) {
      int value = map.getOrDefault(sb.toString(), 0) + 1;
      map.put(sb.toString(), value);
      max = Math.max(max, value);
    } else {
      for (int i = idx + 1; i < target.length(); i++) {
        combi_recursion(i, cnt + 1, sb, target, strLength);
      }
    }
    sb.deleteCharAt(cnt);
  }
}