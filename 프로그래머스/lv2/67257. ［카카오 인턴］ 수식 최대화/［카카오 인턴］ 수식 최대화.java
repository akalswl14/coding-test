import java.util.ArrayList;
import java.util.List;

class Solution {

  private final int[][] cases = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

  public long solution(String expression) {
    List<Character> operator = new ArrayList<>();

    for (int i = 1; i < expression.length(); i++) {
      char value = expression.charAt(i);
      if (value == '+' || value == '-' || value == '*') {
        operator.add(value);
      }
    }

    String[] arr = expression.split("\\p{Punct}");

    long max = 0;
    for (int i = 0; i < 6; i++) {
      long result = 0;
      List<Character> temp = new ArrayList<>(operator);
      List<Long> numbers = new ArrayList<>();
      for (String str : arr) {
        numbers.add(Long.parseLong(str));
      }
      for (int j = 0; j < 3; j++) {
        result = calculate(cases[i][j], temp, numbers);
      }
      max = Math.max(max, Math.abs(result));
    }

    return max;
  }

  private long calculate(int operatorNumber, List<Character> operators, List<Long> numbers) {
    long value = 0;
    char operator = getOperator(operatorNumber);

    while (operators.contains(operator)) {
      int opIdx = operators.indexOf(operator);
      operators.remove(opIdx);
      long left = numbers.get(opIdx);
      long right = numbers.get(opIdx + 1);
      value = doOperator(operator, left, right);
      numbers.set(opIdx, value);
      numbers.remove(opIdx + 1);
    }
    return value;
  }

  private long doOperator(char operator, long left, long right) {
    if (operator == '+') {
      return left + right;
    } else if (operator == '-') {
      return left - right;
    } else {
      return left * right;
    }
  }

  private char getOperator(int command) {
    if (command == 0) {
      return '+';
    } else if (command == 1) {
      return '-';
    } else {
      return '*';
    }
  }
}
