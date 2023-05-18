import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

  public int solution(String numbers) {
    Set<Integer> primeSet = new HashSet<>();
    primeSet.add(2);
    primeSet.add(3);
    primeSet.add(5);
    primeSet.add(7);
    primeSet.add(11);
    primeSet.add(13);
    primeSet.add(17);
    primeSet.add(19);
    int maxPrime = 19;

    Set<Integer> caseSet = getNumbers(numbers);

    int answer = 0;
    for (int target : caseSet) {
      if (target == 1) {
        continue;
      }
      if (primeSet.contains(target)) {
        answer++;
        continue;
      }
      if(target<maxPrime) {
        continue;
      }

      boolean isPrime = true;
      for (int i = 2; i <= target/2; i++) {
        if(target%i==0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        answer++;
        primeSet.add(target);
      }
    }

    return answer;
  }

  private Set<Integer> getNumbers(String numberString) {
    Set<Integer> set = new HashSet<>();
    generateNumbers("", numberString, set);

    return set;
  }

  private void generateNumbers(String prefix, String suffix, Set<Integer> set) {
    if (suffix.length() == 0) {
      int num = Integer.parseInt(prefix);
      if (num != 0) {
        set.add(num);
      }
      return;
    }

    for (int i = 0; i < suffix.length(); i++) {
      String number = prefix + suffix.charAt(i);
      if(number=="0") {
        continue;
      }
      set.add(Integer.parseInt(number));
      generateNumbers(
          number,
          suffix.substring(0, i) + suffix.substring(i + 1),
          set);
    }
  }
}